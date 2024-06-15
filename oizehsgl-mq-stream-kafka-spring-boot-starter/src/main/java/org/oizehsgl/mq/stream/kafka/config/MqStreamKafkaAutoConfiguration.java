package org.oizehsgl.mq.stream.kafka.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author oizehsgl
 */
@AutoConfiguration
@PropertySource("classpath:oizehsgl-mq-stream-kafka.properties")
public class MqStreamKafkaAutoConfiguration {}
