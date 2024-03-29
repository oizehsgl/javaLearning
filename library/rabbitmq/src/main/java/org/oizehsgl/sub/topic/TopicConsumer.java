package org.oizehsgl.sub.topic;

import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.sub.topic.config.TopicExchangeConfig;
import org.oizehsgl.sub.topic.config.TopicQueueConfig;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * topicConsumer
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Slf4j
@Component
public class TopicConsumer {
    @Autowired
    private TopicQueueConfig topicQueueConfig;

    /**
     * *  (星号) 用来表示一个单词 (必须出现的)
     * #  (井号) 用来表示任意数量（零个或多个）单词*
     *
     * @param message
     */
    @RabbitHandler
    @RabbitListener(queues = TopicQueueConfig.QUEUE1, ackMode = "MANUAL")
    public void consumer1(Message message) {
        System.out.printf("消费者: <%s> 从: <%s> 消息: <%s>%n",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                TopicQueueConfig.QUEUE1,
                new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(queues = TopicQueueConfig.QUEUE2)
    public void consumer2(Message message) {
        System.out.printf("消费者: <%s> 从: <%s> 消息: <%s>%n",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                TopicQueueConfig.QUEUE2,
                new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(queuesToDeclare = @Queue(TopicQueueConfig.QUEUE1))
    public void consumer3(Message message) {
        System.out.printf("消费者: <%s> 从: <%s> 消息: <%s>%n",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                TopicQueueConfig.QUEUE1,
                new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(value = @Queue(), exchange = @Exchange(value = TopicExchangeConfig.EXCHANGE, type = ExchangeTypes.TOPIC)))
    public void consumer4(Message message) {
        System.out.printf("消费者: <%s> 从: <%s> 消息: <%s>%n",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                null,
                new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(value = @Queue(), exchange = @Exchange(value = TopicExchangeConfig.EXCHANGE, type = ExchangeTypes.TOPIC)))
    public void consumer5(Message message) {
        System.out.printf("消费者: <%s> 从: <%s> 消息: <%s>%n",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                null,
                new String(message.getBody()));
    }
}
