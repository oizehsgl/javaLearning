package org.oizehsgl.sub.topic.config;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * topicExchange
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Configuration
public class TopicExchangeConfig {
    public static final String EXCHANGE="topicExchange";

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(EXCHANGE, true, false);
    }
}
