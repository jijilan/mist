package cn.jijl.mist.modules.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.concurrent.CountDownLatch;

/**
 * @Author jijl
 * @Description: 接收消息
 * @Date 17:04 2019/10/28
 * @Param
 * @return
 **/
@Slf4j
public class ReceiveMessage{

    private CountDownLatch latch;

    @Autowired
    public ReceiveMessage(CountDownLatch countDownLatch) {
        this.latch = countDownLatch;
    }

    public void receiveMessage(Serializable message) {
        log.info("message2接收到消息了:{}", message);
        try {
            Thread.sleep(2000);
        }catch (Exception e){
        }
        log.info("这是两秒后打印-----");
    }

    public void receiveMessage2(Serializable message) {
        log.info("message2接收到消息了:{}", message);
    }

}

