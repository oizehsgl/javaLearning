package org.oizehsgl.sub.topic;

import lombok.RequiredArgsConstructor;
import org.oizehsgl.sub.topic.config.TopicBindingConfig;
import org.oizehsgl.sub.topic.config.TopicExchangeConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * topicProducer
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Service
@RequiredArgsConstructor
public class TopicProducer {
    private final RabbitTemplate rabbitTemplate;

    public Object sendMsg() {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setExpiration("5000");
        Message message = new Message("hello world".getBytes(), messageProperties);
        System.out.println("开始发送消息 : " + message);
        rabbitTemplate.convertAndSend(TopicExchangeConfig.EXCHANGE, TopicBindingConfig.ROUTING_KEY, message, correlationData);
        System.out.println("结束发送消息 : " + message);
        return correlationData;
    }
}
