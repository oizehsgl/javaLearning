package org.oizehsgl.sub.fanout;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.sub.fanout.config.FanoutExchangeConfig;
import org.oizehsgl.sub.fanout.config.FanoutQueueConfig;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * fanoutConsumer
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Slf4j
@Component
public class FanoutConsumer {
    @Autowired
    private FanoutQueueConfig fanoutQueueConfig;

    /**
     * 尽管设置了两个消费者，但是只有一个能够消费成功
     * 多次发送则轮训消费：
     * FanoutReceiver消费者收到消息1  : 发送一条测试消息：fanout
     * FanoutReceiver消费者收到消息2  : 发送一条测试消息：fanout
     * FanoutReceiver消费者收到消息1  : 发送一条测试消息：fanout
     * FanoutReceiver消费者收到消息2  : 发送一条测试消息：fanout
     * <p>
     * 一个交换机可以绑定多个从。如果通过路由key可以匹配到多个从，消费的时候也只能有一个进行消费
     *
     * @param message
     */
    @RabbitHandler
    @RabbitListener(queues = FanoutQueueConfig.QUEUE1, ackMode = "MANUAL")
    public void consumer1(Message message,Channel channel) {
        System.out.printf("消费者: <%s> 从: <%s> 消息: <%s>%n",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                FanoutQueueConfig.QUEUE1,
                new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(queues = FanoutQueueConfig.QUEUE2)
    public void consumer2(Message message,Channel channel) {
        System.out.printf("消费者: <%s> 从: <%s> 消息: <%s>%n",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                FanoutQueueConfig.QUEUE2,
                new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(queuesToDeclare = @Queue(FanoutQueueConfig.QUEUE1))
    public void consumer3(Message message) {
        System.out.printf("消费者: <%s> 从: <%s> 消息: <%s>%n",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                FanoutQueueConfig.QUEUE1,
                new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(value = @Queue(), exchange = @Exchange(value = FanoutExchangeConfig.EXCHANGE, type = ExchangeTypes.FANOUT)))
    public void consumer4(Message message) {
        System.out.printf("消费者: <%s> 从: <%s> 消息: <%s>%n",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                null,
                new String(message.getBody()));
    }

    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(value = @Queue(), exchange = @Exchange(value = FanoutExchangeConfig.EXCHANGE, type = ExchangeTypes.FANOUT)))
    public void consumer5(Message message, Channel channel) {
        System.out.printf("消费者: <%s> 从: <%s> 消息: <%s>%n",
                Thread.currentThread().getStackTrace()[1].getMethodName(),
                null,
                new String(message.getBody()));
    }
}
