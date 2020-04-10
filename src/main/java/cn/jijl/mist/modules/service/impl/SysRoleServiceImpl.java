package cn.jijl.mist.modules.service.impl;

import cn.jijl.mist.common.result.ResultView;
import cn.jijl.mist.modules.entity.SysRole;
import cn.jijl.mist.modules.mapper.SysRoleMapper;
import cn.jijl.mist.modules.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author jijl
 * @since 2019-11-21
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {

    @Override
    public ResultView getAll() {

        return null;
    }
}
