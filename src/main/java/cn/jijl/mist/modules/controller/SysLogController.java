package cn.jijl.mist.modules.controller;


import cn.jijl.mist.common.result.ResultView;
import cn.jijl.mist.modules.entity.SysLog;
import cn.jijl.mist.modules.service.ISysLogService;
import lombok.extern.slf4j.Slf4j;
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
 * @since 2019-10-25
 */
@Slf4j
@RestController
@RequestMapping("/sys-log")
public class SysLogController {
    @Autowired
    private ISysLogService iSysLogService;

    /**
     * @Author jijl
     * @Description: 测试
     * @Date 14:30 2019/10/27
     * @Param [id]
     * @return cn.jijl.mist.common.result.ResultView
     **/
    @GetMapping("/test")
    public ResultView get(String id) {
        SysLog sysLog = iSysLogService.getById(id);
        log.info("测试{}", sysLog);
        return ResultView.ok(sysLog);
    }
}
