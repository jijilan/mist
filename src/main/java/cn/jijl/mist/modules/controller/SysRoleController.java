package cn.jijl.mist.modules.controller;


import cn.jijl.mist.common.result.ResultView;
import cn.jijl.mist.modules.service.ISysRoleService;
import cn.jijl.mist.modules.service.impl.SysRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author jijl
 * @since 2019-11-21
 */
@RestController
@RequestMapping("/sys-role")
public class SysRoleController {
    @Autowired
    private ISysRoleService sysRoleService;

    @GetMapping
    public ResultView getAll() {

        return sysRoleService.getAll();
    }

}
