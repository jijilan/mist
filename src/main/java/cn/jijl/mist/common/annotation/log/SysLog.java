package cn.jijl.mist.common.annotation.log;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.annotation.*;

/**
 * @author JiJl
 * @Date: Create in 2018/11/22
 * @Description: 业务日志注解
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Order(Ordered.HIGHEST_PRECEDENCE)
public @interface SysLog {

    /**
     * 行为描述，数据类型为String类型
     **/
    String value() default "";
}
