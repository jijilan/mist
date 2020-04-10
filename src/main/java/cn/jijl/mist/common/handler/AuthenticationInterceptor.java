package cn.jijl.mist.common.handler;

import cn.jijl.mist.common.exception.AuthException;
import cn.jijl.mist.common.result.DictionaryEnum;
import cn.jijl.mist.common.result.ResultEnum;
import cn.jijl.mist.common.result.SysConstant;
import cn.jijl.mist.common.utils.JwtUtil;
import cn.jijl.mist.modules.entity.SysManager;
import cn.jijl.mist.modules.redis.RedisService;
import com.alibaba.druid.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: jijl
 * @Description: token认证
 * @Date: 2019/7/2 16:50
 **/
@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    static Long startTime = null;
    static Long entTime = null;
    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws AuthException {
        startTime = System.currentTimeMillis();
        String token = request.getHeader(SysConstant.TOKEN);

        if (StringUtils.isEmpty(token)) {
            throw new AuthException(ResultEnum.CODE_3);
        } else {
            try {
                Integer managerId = JwtUtil.getUniqueId(token, SysConstant.MANAGER_ID);
                /**后台授权拦截业务逻辑部分*/
                SysManager sysManager = (SysManager) redisService.getAuthorizedSubject(managerId);
                //admin放行
                if (SysConstant.ADMIN.equals(sysManager.getUserAcount())) {
                    return true;
                }
                if (sysManager.getIsFlag() == DictionaryEnum.ISFLAG_N.getCode()) {
                    throw new AuthException(ResultEnum.CODE_5);
                }
                request.setAttribute(SysConstant.MANAGER, sysManager);
                request.setAttribute(SysConstant.MANAGER_ID, managerId);
            } catch (NullPointerException e) {
                throw new AuthException(ResultEnum.CODE_403);
            } catch (ClassCastException e) {
                throw new AuthException(ResultEnum.CODE_6);
            } catch (AuthException e) {
                throw new AuthException(e.getResultEnum());
            } catch (Exception e) {
                throw new AuthException(ResultEnum.CODE_403);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        entTime = System.currentTimeMillis();
        log.info("总耗时:{}", entTime - startTime);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
