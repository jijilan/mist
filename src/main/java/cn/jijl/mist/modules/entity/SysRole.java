package cn.jijl.mist.modules.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author jijl
 * @since 2019-11-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysRole extends Model<SysRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色名称
     */
    @TableField("roleName")
    private String roleName;

    /**
     * 备注
     */
    @TableField("roleNote")
    private String roleNote;

    private Date ctime;

    /**
     * 1:有效  2:无效
     */
    @TableField("isFlag")
    private Integer isFlag;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
