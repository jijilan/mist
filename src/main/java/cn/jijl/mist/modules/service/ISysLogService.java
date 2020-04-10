package cn.jijl.mist.modules.service;

import cn.jijl.mist.modules.entity.SysLog;
import com.baomidou.mybatisplus.extension.service.IService;
import org.aspectj.lang.ProceedingJoinPoint;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 系统日志表 服务类
 * </p>
 *
 * @author jijl
 * @since 2019-10-25
 */
public interface ISysLogService extends IService<SysLog> {

    /**
     * 保存系统日志
     *
     * @param request
     * @param sysLog
     * @param point
     */
    void saveBySystem(HttpServletRequest request, cn.jijl.mist.common.annotation.log.SysLog sysLog, ProceedingJoinPoint point, long time) throws Throwable;

    /**
     * 保存异常日志
     *
     * @param request
     */
    void saveByError(HttpServletRequest request, Exception e);
}
