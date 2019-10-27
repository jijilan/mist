package cn.jijl.mist.modules.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 系统日志表
 * </p>
 *
 * @author jijl
 * @since 2019-10-25
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysLog extends Model<SysLog> {

    private static final long serialVersionUID = 1L;

    /**
     * 日志编号
     */
    @TableId(value = "logid", type = IdType.AUTO)
    private Long logid;

    /**
     * 日志类型:1.业务日志 2.异常日志
     */
    private Integer logtype;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户操作
     */
    private String operation;

    /**
     * 请求方式
     */
    private String method;

    /**
     * 请求参数
     */
    private String params;

    /**
     * 请求方法
     */
    private String controller;

    /**
     * 请求路径
     */
    private String url;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 执行时长
     */
    private Long time;

    /**
     * 异常信息
     */
    private String errormessage;

    /**
     * 创建时间
     */
    private Date ctime;


    @Override
    protected Serializable pkVal() {
        return this.logid;
    }

}
