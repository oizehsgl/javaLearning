package org.oizehsgl.sub.headers;

import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.sub.headers.config.HeadersExchangeConfig;
import org.oizehsgl.sub.headers.config.HeadersQueueConfig;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * headersConsumer
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Slf4j
@Component
public class HeadersConsumer {
    @Autowired
    private HeadersQueueConfig headersQueueConfig;

    /**
     * *  (星号) 用来表示一个单词 (必须出现的)
     * #  (井号) 用来表示任意数量（零个或多个）单词*
     *
     * @param message
     */
    @RabbitHandler
    @RabbitListener(queues = HeadersQueueConfig.QUEUE1, ackMode = "MANUAL")
    public void consumer1(Message message) {
        System.out.printf("消费者: <%s> 从: <%s> 消息: <%s>%n",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                HeadersQueueConfig.QUEUE1,
                new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(queues = HeadersQueueConfig.QUEUE2)
    public void consumer2(Message message) {
        System.out.printf("消费者: <%s> 从: <%s> 消息: <%s>%n",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                HeadersQueueConfig.QUEUE2,
                new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(queuesToDeclare = @Queue(HeadersQueueConfig.QUEUE1))
    public void consumer3(Message message) {
        System.out.printf("消费者: <%s> 从: <%s> 消息: <%s>%n",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                HeadersQueueConfig.QUEUE1,
                new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(value = @Queue(), exchange = @Exchange(value = HeadersExchangeConfig.EXCHANGE, type = ExchangeTypes.HEADERS)))
    public void consumer4(Message message) {
        System.out.printf("消费者: <%s> 从: <%s> 消息: <%s>%n",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                null,
                new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(value = @Queue(), exchange = @Exchange(value = HeadersExchangeConfig.EXCHANGE, type = ExchangeTypes.HEADERS)))
    public void consumer5(Message message) {
        System.out.printf("消费者: <%s> 从: <%s> 消息: <%s>%n",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                null,
                new String(message.getBody()));
    }
}
