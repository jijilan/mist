package cn.jijl.mist.common.annotation.valid.impl;

import cn.jijl.mist.common.annotation.valid.Status;
import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * @auther: jijl
 * @Date: Create in 2018/11/29
 * @Description: 自定义状态值校验实现
 **/
public class StatusValidator implements ConstraintValidator<Status, String> {

    private String value;

    private boolean isNotBlank;

    @Override
    public void initialize(Status status) {
        value = status.value();
        isNotBlank = status.isNotBlank();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (StringUtils.isBlank(s)) {
            return !isNotBlank;
        }
        return Pattern.compile(value).matcher(s).matches();
    }
}
