package cn.jijl.mist.modules.entity.view;

import cn.jijl.mist.modules.entity.SysRoleMenu;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 角色表
 * </p>
 *
 * @author jijl
 * @since 2019-11-21
 */
@Data
public class SysRoleview {
    private String id;
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 备注
     */
    private String roleNote;

    private Date ctime;

    /**
     * 1:有效  2:无效
     */
    private Integer isFlag;

    private List<SysRoleMenu> sysRoleMenus;
}
