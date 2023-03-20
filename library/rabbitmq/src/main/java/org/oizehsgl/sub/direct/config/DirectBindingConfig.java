package org.oizehsgl.sub.direct.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * directBindding
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Configuration
public class DirectBindingConfig {
    public static final String ROUTING_KEY="directRoutingKey";

    @Bean
    public Binding bindingDirectExchange1(Queue directQueue1, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue1).to(directExchange).with(ROUTING_KEY);
    }

    @Bean
    public Binding bindingDirectExchange2(Queue directQueue2, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with(ROUTING_KEY);
    }
}
