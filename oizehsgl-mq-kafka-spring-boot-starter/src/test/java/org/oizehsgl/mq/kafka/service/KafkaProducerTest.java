package org.oizehsgl.mq.kafka.service;

import jakarta.annotation.Resource;
import org.checkerframework.checker.units.qual.K;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author oizehsgl
 */
@SpringBootTest
class KafkaProducerTest {
  @Resource KafkaProducer kafkaProducer;

  @Test
  void send() throws InterruptedException {
    kafkaProducer.send("test1","a");
    kafkaProducer.send("test2","a");
    kafkaProducer.send("test3","a");
    kafkaProducer.send("test4","b");
    kafkaProducer.send("test5","b");
    kafkaProducer.send("test6","c");
    TimeUnit.SECONDS.sleep(1);
  }
}
