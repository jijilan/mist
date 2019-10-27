package cn.jijl.mist.modules.controller;


import cn.jijl.mist.common.result.ResultEnum;
import cn.jijl.mist.common.result.ResultView;
import cn.jijl.mist.common.utils.JsonUtils;
import cn.jijl.mist.modules.entity.SysLog;
import cn.jijl.mist.modules.service.ISysLogService;
import com.alibaba.druid.support.json.JSONUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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

    @GetMapping("/get")
    public ResultView get(String id ) {
        QueryWrapper<SysLog> qw = new QueryWrapper<>();
        qw.lambda().eq(StringUtils.isNotBlank(id),SysLog ::getLogid,id);
        SysLog sysLog = iSysLogService.getOne(qw);
        log.info("测试呀{}",sysLog);
        return ResultView.ok(sysLog) ;
    }
}
