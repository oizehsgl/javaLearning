package org.oizehsgl.sub.direct.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * directExchange
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Configuration
public class DirectExchangeConfig {
    public static final String EXCHANGE="directExchange";

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(EXCHANGE, true, false);
    }
}
