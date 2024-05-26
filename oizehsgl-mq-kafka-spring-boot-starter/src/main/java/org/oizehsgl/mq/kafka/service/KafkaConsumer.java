package org.oizehsgl.mq.kafka.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Slf4j
@Component
public class KafkaConsumer {
  @KafkaListener(topics = {"topic_1"})
  public void listen(List<ConsumerRecord<String, Object>> records, Acknowledgment ack) {
    log.info("拉取消息[size<{}>]", records.size());
    try {
      for (ConsumerRecord<String, Object> record : records) {
        log.error(
            "消费[topic<{}>,partition<{}>,value<{}>]",
            record.topic(),
            record.partition(),
            record.value());
      }
    } catch (Exception e) {
    } finally {
      ack.acknowledge();
    }
  }
}
