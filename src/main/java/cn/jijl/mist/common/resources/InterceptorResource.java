package cn.jijl.mist.common.resources;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @auther: jijl
 * @Date: Create in 2018/10/16
 * @Description:
 **/
@Getter
@Setter
@Component
public class InterceptorResource {



    @Value("#{'${interceptor.admin-authentication.addPathPatterns}'.split(',')}")
    private String[] adminAuthenticationAddPathPatterns;
    @Value("#{'${interceptor.admin-authentication.excludePathPatterns}'.split(',')}")
    private String[] adminAuthenticationExcludePathPatterns;

}
