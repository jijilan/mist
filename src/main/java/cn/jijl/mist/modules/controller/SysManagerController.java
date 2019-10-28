package cn.jijl.mist.modules.controller;


import cn.jijl.mist.common.result.ResultView;
import cn.jijl.mist.common.result.SysConstant;
import cn.jijl.mist.common.utils.JsonUtils;
import cn.jijl.mist.modules.entity.SysLog;
import cn.jijl.mist.modules.entity.SysManager;
import cn.jijl.mist.modules.redis.RedisService;
import cn.jijl.mist.modules.service.ISysManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jijl
 * @since 2019-10-28
 */
@Slf4j
@RestController
@RequestMapping("/sys-manager")
public class SysManagerController {
    @Autowired
    private ISysManagerService iSysManagerService;
    @GetMapping("/getManagerById")
    public ResultView get(String id) {
        SysManager sysManager = iSysManagerService.getById(id);
        return ResultView.ok(sysManager);
    }
}
