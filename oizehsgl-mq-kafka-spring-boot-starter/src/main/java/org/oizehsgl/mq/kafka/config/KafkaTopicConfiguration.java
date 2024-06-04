package org.oizehsgl.mq.kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.Map;

/**
 * @author oizehsgl
 */
@Configuration
public class KafkaTopicConfiguration {
  @Bean
  public NewTopic topic1() {
    return TopicBuilder.name("topic_1")
        .partitions(3)
        .replicas(3)
        .configs(Map.of("min.insync.replicas", "2"))
        .build();
  }
}
