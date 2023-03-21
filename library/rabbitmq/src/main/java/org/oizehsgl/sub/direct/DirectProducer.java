package org.oizehsgl.sub.direct;

import lombok.RequiredArgsConstructor;
import org.oizehsgl.sub.direct.config.DirectBindingConfig;
import org.oizehsgl.sub.direct.config.DirectExchangeConfig;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * directProducer
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Service
@RequiredArgsConstructor
public class DirectProducer {
    private final RabbitTemplate rabbitTemplate;

    public Object sendMsg() {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setExpiration("10000");
        String exchange = DirectExchangeConfig.EXCHANGE;
        String routingKey = DirectBindingConfig.ROUTING_KEY;
        Message message = new Message(String.format("%s + %s", exchange, routingKey).getBytes(), messageProperties);
        System.out.println("开始发送消息 : " + message);
        rabbitTemplate.convertAndSend(exchange, routingKey, message, correlationData);
        System.out.println("结束发送消息 : " + message);
        return correlationData;
    }
}
