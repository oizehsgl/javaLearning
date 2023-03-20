package org.oizehsgl.sub.direct;

import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.sub.direct.config.DirectExchangeConfig;
import org.oizehsgl.sub.direct.config.DirectQueueConfig;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * directConsumer
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Slf4j
@Component
public class DirectConsumer {
    @Autowired
    private DirectQueueConfig directQueueConfig;

    /**
     * fanout交换机： 扇型交换机，这个交换机没有路由键概念，就算你绑了路由键也是无视的。 这个交换机在接收到消息后，会直接转发到绑定到它上面的所有队列
     * 同一个队列监听多次，只会消费一次。
     * 交换机绑定的多个队列都可以收到消息
     *
     * @param message
     */
    @RabbitHandler
    @RabbitListener(queues = DirectQueueConfig.QUEUE1, ackMode = "MANUAL")
    public void consumer1(Message message) {
        System.out.printf("消费者: <%s> 从: <%s> 消息: <%s>%n",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                DirectQueueConfig.QUEUE1,
                new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(queues = DirectQueueConfig.QUEUE2)
    public void consumer2(Message message) {
        System.out.printf("消费者: <%s> 从: <%s> 消息: <%s>%n",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                DirectQueueConfig.QUEUE2,
                new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(queuesToDeclare = @Queue(DirectQueueConfig.QUEUE1))
    public void consumer3(Message message) {
        System.out.printf("消费者: <%s> 从: <%s> 消息: <%s>%n",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                DirectQueueConfig.QUEUE1,
                new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(bindings =@QueueBinding(value = @Queue(),exchange = @Exchange(value = DirectExchangeConfig.EXCHANGE,type = ExchangeTypes.DIRECT)))
    public void consumer4(Message message) {
        System.out.printf("消费者: <%s> 从: <%s> 消息: <%s>%n",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                DirectQueueConfig.QUEUE1,
                new String(message.getBody()));
    }
}
