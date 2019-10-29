package cn.jijl.mist.modules.service.impl;

import cn.jijl.mist.common.result.DictionaryEnum;
import cn.jijl.mist.common.result.ResultEnum;
import cn.jijl.mist.common.result.ResultView;
import cn.jijl.mist.common.utils.DESCode;
import cn.jijl.mist.modules.entity.SysManager;
import cn.jijl.mist.modules.mapper.SysManagerMapper;
import cn.jijl.mist.modules.service.ISysManagerService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jijl
 * @since 2019-10-28
 */
@Service
public class SysManagerServiceImpl extends ServiceImpl<SysManagerMapper, SysManager> implements ISysManagerService {

    @Override
    public ResultView login(String userAccount, String userPassword) {
        QueryWrapper<SysManager> qw = new QueryWrapper<>();
        qw.lambda().eq(SysManager::getUserAcount, userAccount);
        SysManager manager = getOne(qw);
        if (manager == null) {
            return ResultView.error(ResultEnum.CODE_7);
        }
        if (!DESCode.encode(userPassword).equals(manager.getPassWord())) {
            return ResultView.error(ResultEnum.CODE_8);
        }
        if (manager.getIsFlag() == DictionaryEnum.ISFLAG_N.getCode()) {
            return ResultView.error(ResultEnum.CODE_5);
        }
        return ResultView.ok(manager);
    }
}
