package org.oizehsgl.mq.kafka.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;

import java.util.concurrent.TimeUnit;

/**
 * @author oizehsgl
 */
@SpringBootTest
class KafkaProducerTest {
  @Resource KafkaProducer kafkaProducer;
  @Resource
  KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;

  @Test
  void send() throws InterruptedException {
    kafkaProducer.send("test1", "a");
    kafkaProducer.send("test2", "a");
    kafkaProducer.send("test3", "a");
    TimeUnit.SECONDS.sleep(3);
    kafkaListenerEndpointRegistry.getListenerContainer(KafkaConsumer.TOPIC_1).pause();
    kafkaListenerEndpointRegistry.getListenerContainer(KafkaConsumer.TOPIC_1).pause();
    System.out.println(
        kafkaListenerEndpointRegistry.getListenerContainer(KafkaConsumer.TOPIC_1).isRunning());
    System.out.println(
        kafkaListenerEndpointRegistry
            .getListenerContainer(KafkaConsumer.TOPIC_1)
            .isPauseRequested());
    kafkaProducer.send("test4", "b");
    kafkaProducer.send("test5", "b");
    kafkaProducer.send("test6", "c");
    TimeUnit.SECONDS.sleep(3);
    kafkaListenerEndpointRegistry.getListenerContainer(KafkaConsumer.TOPIC_1).resume();
    TimeUnit.SECONDS.sleep(1);
  }
}
