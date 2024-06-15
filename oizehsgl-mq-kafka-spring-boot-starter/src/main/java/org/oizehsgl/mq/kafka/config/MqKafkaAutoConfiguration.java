package org.oizehsgl.mq.kafka.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author oizehsgl
 */
@AutoConfiguration
@PropertySource("classpath:oizehsgl-mq-kafka.properties")
public class MqKafkaAutoConfiguration {}
