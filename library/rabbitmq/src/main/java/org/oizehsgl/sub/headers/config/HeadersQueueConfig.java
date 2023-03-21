package org.oizehsgl.sub.headers.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * headersQueue
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Configuration
public class HeadersQueueConfig {
    public final static String QUEUE1 = "headersQueue1";
    public final static String QUEUE2 = "headersQueue2";

    @Bean
    public Queue headersQueue1() {
        return new Queue(QUEUE1, true);
    }
    @Bean
    public Queue headersQueue2() {
        return new Queue(QUEUE2, true);
    }
}
