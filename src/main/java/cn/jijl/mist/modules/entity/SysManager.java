package cn.jijl.mist.modules.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author jijl
 * @since 2019-10-28
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysManager extends Model<SysManager> {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员编号
     */
    @TableId(value = "managerId", type = IdType.AUTO)
    private Integer managerId;

    /**
     * 用户名称
     */
    @TableField("userName")
    private String userName;

    /**
     * 用户账号
     */
    @TableField("userAcount")
    private String userAcount;

    /**
     * 用户密码
     */
    @TableField("passWord")
    private String passWord;

    /**
     * 1:正常 2:禁用
     */
    @TableField("isFlag")
    private Integer isFlag;

    /**
     * 创建时间
     */
    @TableField("cTime")
    private Date cTime;


    @Override
    protected Serializable pkVal() {
        return this.managerId;
    }

}
