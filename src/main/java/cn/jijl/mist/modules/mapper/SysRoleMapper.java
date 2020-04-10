package cn.jijl.mist.modules.mapper;

import cn.jijl.mist.modules.entity.SysRole;
import cn.jijl.mist.modules.entity.view.SysRoleview;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author jijl
 * @since 2019-11-21
 */
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRoleview> getAll();
}
