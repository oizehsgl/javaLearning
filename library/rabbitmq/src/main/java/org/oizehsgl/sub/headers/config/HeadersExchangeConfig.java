package org.oizehsgl.sub.headers.config;

import org.springframework.amqp.core.HeadersExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * headersExchange
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Configuration
public class HeadersExchangeConfig {
    public static final String EXCHANGE="headersExchange";

    @Bean
    public HeadersExchange headersExchange() {
        return new HeadersExchange(EXCHANGE, true, false);
    }
}
