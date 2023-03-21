package org.oizehsgl.sub.headers.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * headersBindding
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Configuration
public class HeadersBindingConfig {
    public static final String ROUTING_KEY = "headers.routing.key";

    @Bean
    public Binding bindingHeadersExchange1(Queue headersQueue1, HeadersExchange headersExchange) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", "value");
        return BindingBuilder.bind(headersQueue1).to(headersExchange).whereAll(map).match();
    }

    @Bean
    public Binding bindingHeadersExchange2(Queue headersQueue2, HeadersExchange headersExchange) {
        return BindingBuilder.bind(headersQueue2).to(headersExchange).where("key").exists();
    }
}
