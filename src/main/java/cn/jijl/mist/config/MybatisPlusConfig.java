package cn.jijl.mist.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;

/**
 * @Author jijl
 * @Description: mybatis-plus 配置类
 * @Date 18:35 2019/10/24
 * @Param
 * @return
 **/
@Configuration
public class MybatisPlusConfig {
//    @Bean
//    public PerformanceInterceptor performanceInterceptor(){
//        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
//        /*<!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 -->*/
//        performanceInterceptor.setMaxTime(1000);
//        performanceInterceptor.setFormat(true);
//        return performanceInterceptor;
//    }

    /**
     * @Description: 分页插件
     **/
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }


}
