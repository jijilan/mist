package cn.jijl.mist.modules.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 管理员角色表
 * </p>
 *
 * @author jijl
 * @since 2019-11-21
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysManagerRole extends Model<SysManagerRole> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    @TableField("roleId")
    private String roleId;

    /**
     * 管理员id
     */
    @TableField("managerId")
    private String managerId;


    @Override
    protected Serializable pkVal() {
        return null;
    }

}
