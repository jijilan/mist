package cn.jijl.mist.common.result;

import lombok.Getter;

/**
 * @Author: liujiebang
 * @Description: 自定义参数枚举
 * @Date: 2018/7/2 16:54
 **/
@Getter
public enum ResultEnum {


    CODE_1(1, "操作成功！"),
    CODE_2(2, "操作失败！");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
