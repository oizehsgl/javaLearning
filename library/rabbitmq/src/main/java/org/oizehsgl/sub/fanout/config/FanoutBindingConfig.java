package org.oizehsgl.sub.fanout.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * fanoutBindingConfig
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Configuration
public class FanoutBindingConfig {
    public static final String ROUTING_KEY="fanoutRoutingKey";

    @Bean
    public Binding bindingFanoutExchange1(Queue fanoutQueue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    @Bean
    public Binding bindingFanoutExchange2(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }
}
