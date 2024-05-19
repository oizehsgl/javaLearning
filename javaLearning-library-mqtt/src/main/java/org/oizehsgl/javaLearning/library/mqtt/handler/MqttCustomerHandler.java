package org.oizehsgl.javaLearning.library.mqtt.handler;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

/**
 * mqtt消费者处理器
 *
 * @author oizehsgl
 */
@Slf4j
@Component
public class MqttCustomerHandler implements MessageHandler {

  // TODO: 使用async注解代替线程池
  // 创建io密集型线程池
  ExecutorService threadPool =
      new ThreadPoolExecutor(
          Runtime.getRuntime().availableProcessors() * 2,
          Runtime.getRuntime().availableProcessors() * 4,
          1,
          TimeUnit.HOURS,
          new LinkedBlockingQueue<>(100),
          new ThreadPoolExecutor.DiscardOldestPolicy());

  @Override
  public void handleMessage(Message<?> message) throws MessagingException {
    // 获取topic
    String topic =
        Objects.requireNonNull(message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC)).toString();
    try {
      byte[] bytes = (byte[]) message.getPayload();
      log.info("消费消息[主题<{}>]", topic);
      if (MqttTopic.isMatched("#", topic)) {
        // 消息处理
        threadPool.execute(
            () -> {
              log.warn("消费消息[主题<{}>,负载<{}>]", topic, new String(bytes));
            });
      } else {
        log.warn("消费消息(错误,主题未知)[主题<{}>]", topic);
      }
    } catch (Exception e) {
      log.error("消费消息(异常)[主题<{}>]", topic, e);
    }
  }
}
