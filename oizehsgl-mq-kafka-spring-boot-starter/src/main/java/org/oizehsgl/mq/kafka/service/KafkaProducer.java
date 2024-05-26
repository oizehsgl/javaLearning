package org.oizehsgl.mq.kafka.service;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Slf4j
@Component
public class KafkaProducer {

  @Resource private KafkaTemplate<String, Object> kafkaTemplate;

  public void send(String message, String key) {
    kafkaTemplate
        .send("topic_1", key, message)
        .thenAccept(
            result -> {
              log.info("发送成功[result<{}>]", result);
            })
        .exceptionally(
            (e) -> {
              log.info("发送异常[error<{}>]", e.getMessage(), e);
              return null;
            });
  }
}
