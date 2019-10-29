package cn.jijl.mist.common.exception;

import cn.jijl.mist.common.result.ResultEnum;
import lombok.Getter;

/**
 * @Author jijl
 * @Description: 授权异常
 * @Date 17:12 2019/10/28
 * @Param
 * @return
 **/
@Getter
public class AuthException extends Exception {

    private ResultEnum resultEnum;

    public AuthException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.resultEnum = resultEnum;
    }

    public AuthException(ResultEnum resultEnum, String message) {
        super(message);
        this.resultEnum = resultEnum;
    }


}
