package cn.jijl.mist.modules.controller.base;

import cn.jijl.mist.common.utils.JwtUtil;
import cn.jijl.mist.modules.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @auther: jijl
 * @Date: Create in 2018/10/16
 * @Description:
 **/
public class BaseController {

    @Autowired
    protected RedisService redisService;

    /**
     * 生成token
     *
     * @param unique    id标识
     * @param uniqueId  用户编号-或管理员编号
     * @param obj       用户对象或管理员对象
     * @param TTLMillis token有效时间
     * @return
     */
    protected String jwtToken(String unique, Integer uniqueId, Object obj, long TTLMillis) {
        String jwtToken = JwtUtil.createJWT(unique,
                uniqueId.toString() ,
                TTLMillis);
        redisService.setAuthorizedSubject(uniqueId, obj, TTLMillis / 1000);
        return jwtToken;
    }

}
