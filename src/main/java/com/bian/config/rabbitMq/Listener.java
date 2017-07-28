package com.bian.config.rabbitMq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by Mr.Bi on 2017/3/1.
 */
@Component
public class Listener {

    @RabbitListener(queues = "spring-boot")
    public void processMessage(String context) {
        System.out.println("receiving : " + context);
    }

    @PostConstruct
}
