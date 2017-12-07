package cn.three.module.rabbitmq.amqp;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Administrator on 2017/11/30 0030.
 */
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue(){

        return new Queue("hello");
    }

}
