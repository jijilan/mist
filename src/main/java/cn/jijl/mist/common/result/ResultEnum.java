package cn.jijl.mist.common.result;

import lombok.Getter;

/**
 * @Author: jijl
 * @Description: 自定义参数枚举
 * @Date: 2019/7/2 16:54
 **/
@Getter
public enum ResultEnum {


    CODE_1(1, "操作成功！"),
    CODE_2(2, "操作失败！"),
    CODE_401(401, "账号或者密码错误！"),
    CODE_403(403, "没有获取授权！"),
    CODE_404(404, "找不到该路径！"),
    CODE_405(405, "请求方式错误！"),
    CODE_406(406, "Not Acceptable"),
    CODE_415(415, "请求参数格式错误！"),
    CODE_500(500, "服务器出错了，请联系后台开发人员！"),
    CODE_9999(9999, "服务器无法处理请求！");

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
