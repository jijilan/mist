package cn.jijl.mist.modules.controller;


import cn.jijl.mist.modules.entity.SysLog;
import cn.jijl.mist.modules.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 系统日志表 前端控制器
 * </p>
 *
 * @author jijl
 * @since 2019-10-24
 */
@RestController
@RequestMapping("/sys-log")
public class SysLogController {

    @Autowired
    private ISysLogService iSysLogService;

    @GetMapping("/get")
    public String get() {
        SysLog sysLog = iSysLogService.getById((long) 1);
        System.out.println(sysLog);
        return "";
    }
}
