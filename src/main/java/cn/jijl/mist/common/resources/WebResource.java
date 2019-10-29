package cn.jijl.mist.common.resources;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @auther: jijl
 * @Date: Create in 2018/10/16
 * @Description:
 **/
@Getter
@Setter
@ConfigurationProperties(prefix = "web")
@Component
public class WebResource {

    private String staticResourcePath;

    private String welcomePath;

    private String projectPath;

    private String qrCodePath;
}
