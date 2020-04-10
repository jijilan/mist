package cn.jijl.mist.modules.service;

import cn.jijl.mist.common.result.ResultView;
import cn.jijl.mist.modules.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author jijl
 * @since 2019-11-21
 */
public interface ISysRoleService extends IService<SysRole> {

    /**
     * @return cn.jijl.mist.common.result.ResultView
     * @Author jijl
     * @Description: 获取全部 测试一对多 多对多
     * @Date 15:10 2019/11/21
     * @Param []
     **/
    ResultView getAll();
}
