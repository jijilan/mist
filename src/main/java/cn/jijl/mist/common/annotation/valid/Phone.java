package cn.jijl.mist.common.annotation.valid;



import cn.jijl.mist.common.annotation.valid.impl.PhoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @Author jijl
 * @Descrition: 自定义手机号码
 * @Date: Create in 2018/11/26
 **/
@Constraint(validatedBy = PhoneValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Phone {

    String message() default "手机号格式不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
