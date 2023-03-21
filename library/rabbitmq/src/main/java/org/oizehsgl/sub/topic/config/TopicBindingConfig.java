package org.oizehsgl.sub.topic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * topicBindding
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Configuration
public class TopicBindingConfig {
    public static final String ROUTING_KEY="topic.routing.key";

    @Bean
    public Binding bindingTopicExchange1(Queue topicQueue1, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue1).to(topicExchange).with("topic.#");
    }

    @Bean
    public Binding bindingTopicExchange2(Queue topicQueue2, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue2).to(topicExchange).with("#.routing.#");
    }
}
