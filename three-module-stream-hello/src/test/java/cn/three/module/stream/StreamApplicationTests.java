package cn.three.module.stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/12/5 0005.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class StreamApplicationTests {
    @Autowired
    private SinkSender sinkSender;

    @Test
    public void ctLoad(){
        sinkSender.output().send(MessageBuilder.withPayload("From SinkSender").build());
    }
}
