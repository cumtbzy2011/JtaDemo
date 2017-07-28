package com.bian.config.rabbitMq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Mr.Bi on 2017/3/1.
 */
@Configuration
public class RabbitMQConfig {
    final static String queueName = "spring-boot";

    @Bean
    public Queue queue(){
        return new Queue(queueName, false);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("spring-boot-exchange");
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with(queueName);
    }

//    @Bean
//    public SimpleMessageListenerContainer mycontainer(ConnectionFactory connectionFactory, MessageListenerAdapter adapter){
//        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.setMessageListener(adapter);
//        return container;
//    }
}
