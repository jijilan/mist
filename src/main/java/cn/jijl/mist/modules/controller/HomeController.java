package cn.jijl.mist.modules.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author jijl
 * @Description: 测试controller
 * @Date 15:34 2019/10/24
 **/
@RestController
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "Hello, SpringBoot!";
    }

    @GetMapping("/get")
    public String get(){
        return "Hello, SpringBoot, get!";
    }
}
