package cn.jijl.mist.common.config;


import cn.jijl.mist.common.result.SysConstant;
import cn.jijl.mist.modules.redis.ReceiveMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: jijl
 * @Description: redis配置类
 * @Date: 2019/6/27 15:05
 **/
@Slf4j
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        // 配置redisTemplate
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.afterPropertiesSet();
        redisTemplate.opsForValue().get(SysConstant.PROJECT_NAME);
        log.info("-------------------------------------------------");
        log.info("---------------local redis success---------------");
        log.info("-------------------------------------------------");
        return redisTemplate;

    }
    /**
     * 配置监听器1
     *
     * @return
     */
    @Bean
    public MessageListenerAdapter listenerAdapter(ReceiveMessage receiveMessage) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiveMessage, "receiveMessage");
        messageListenerAdapter.setSerializer(new GenericJackson2JsonRedisSerializer());
        return messageListenerAdapter;
    }


    /**
     * 配置监听器2
     *
     * @return
     */
    @Bean
    public MessageListenerAdapter listenerAdapter2(ReceiveMessage receiveMessage) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(receiveMessage, "receiveMessage2");
        messageListenerAdapter.setSerializer(new GenericJackson2JsonRedisSerializer());
        return messageListenerAdapter;
    }

    /**
     * 初始化监听器
     *
     * @param connectionFactory
     * @param listenerAdapter
     * @param listenerAdapter2
     * @return
     */
    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory,
                                                   MessageListenerAdapter listenerAdapter,
                                                   MessageListenerAdapter listenerAdapter2) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic(SysConstant.Redis.MESSAGE1));
        container.addMessageListener(listenerAdapter2, new PatternTopic(SysConstant.Redis.MESSAGE2));
        return container;
    }

    /**
     * 消息监听者1
     *
     * @return
     */
    @Bean
    public ReceiveMessage receiveMessage(CountDownLatch countDownLatch) {
        return new ReceiveMessage(countDownLatch);
    }

    /**
     * 消息监听者2
     *
     * @return
     */
    @Bean
    public ReceiveMessage receiveMessage2(CountDownLatch countDownLatch) {
        return new ReceiveMessage(countDownLatch);
    }

    @Bean
    public CountDownLatch countDownLatch() {
        return new CountDownLatch(1);
    }

}

