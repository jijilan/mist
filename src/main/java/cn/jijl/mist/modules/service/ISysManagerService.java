package cn.jijl.mist.modules.service;

import cn.jijl.mist.common.result.ResultView;
import cn.jijl.mist.modules.entity.SysManager;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author jijl
 * @since 2019-10-28
 */
public interface ISysManagerService extends IService<SysManager> {

    /**
     * @return boolean
     * @Description: 登录
     * @Date 9:30 2019/10/29
     * @Param userAccount
     * @Param userPassword
     **/
    ResultView login(String userAccount, String userPassword);
}
