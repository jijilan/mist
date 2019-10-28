package cn.jijl.mist.modules.controller;

import cn.jijl.mist.common.result.ResultView;
import cn.jijl.mist.common.result.SysConstant;
import cn.jijl.mist.modules.redis.RedisService;
import org.apache.catalina.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author jijl
 * @Description: 测试controller
 * @Date 15:34 2019/10/24
 **/
@RequestMapping("/redis")
@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @GetMapping("/testSet")
    public ResultView testSet() {
        redisService.set("test", "这是一段测试数据");
        return ResultView.ok();
    }

    @GetMapping("/testGet")
    public ResultView testGet() {
        return ResultView.ok(redisService.get("test"));
    }

    @GetMapping("/testMassage")
    public ResultView testMassage() {
        redisService.sendMessage(SysConstant.Redis.MESSAGE1, "一段消息");
        return ResultView.ok();
    }
}
