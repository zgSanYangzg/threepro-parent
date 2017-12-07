package cn.three.module.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.MessageChannel;

/**
 * Created by Administrator on 2017/12/5 0005.
 */
public interface SinkSender {

    @Output(Sink.INPUT)
    MessageChannel output();
}
