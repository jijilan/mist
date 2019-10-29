package cn.jijl.mist.common.result;

import lombok.Getter;

/**
 * @Author jijl
 * @Description: 数据字段枚举
 * @Date 17:29 2019/10/28
 * @Param
 * @return
 **/
@Getter
public enum DictionaryEnum {

    ISFLAG_Y(1, "有效/正常"),
    ISFLAG_N(2, "无效/禁用"),

    IS_DEL_N(1, "未删除"),
    IS_DEL_Y(2, "已删除");


    private int code;

    private String name;

    DictionaryEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
