package cn.jijl.mist.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author jijl
 * @Description: mybatis-plus 配置类
 * @Date 18:35 2019/10/24
 * @Param
 * @return
 **/
@Configuration
public class MybatisPlusConfig {
    /**
     * @Description: 分页插件
     **/
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


}
