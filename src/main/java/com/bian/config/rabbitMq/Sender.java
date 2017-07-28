package com.bian.config.rabbitMq;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Mr.Bi on 2017/3/1.
 */
@Component
public class Sender {
    @Autowired
    private AmqpTemplate rabbitTemplate;
    @Autowired
    private AmqpAdmin amqpAdmin;

    public String send(String message) {

        rabbitTemplate.convertAndSend("spring-boot-exchange", "spring-boot", message);
        return "success";
    }
}
