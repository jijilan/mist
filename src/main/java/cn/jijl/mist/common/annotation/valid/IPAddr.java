package cn.jijl.mist.common.annotation.valid;


import cn.jijl.mist.common.annotation.valid.impl.IPAddrValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Author jijl
 * @Descrition: 自定义IP
 * @Date: Create in 2018/11/26
 **/
@Constraint(validatedBy = IPAddrValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IPAddr {

    String message() default "IP地址格式不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
