package org.oizehsgl.sub.fanout.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * fanoutExchangeConfig
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Configuration
public class FanoutExchangeConfig {
        public static final String EXCHANGE="fanoutExchange";

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(EXCHANGE, true, false);
    }
}
