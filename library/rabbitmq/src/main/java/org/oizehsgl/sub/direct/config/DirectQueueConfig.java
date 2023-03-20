package org.oizehsgl.sub.direct.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * directQueue
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Configuration
public class DirectQueueConfig {
    public final static String QUEUE1 = "directQueue1";
    public final static String QUEUE2 = "directQueue2";

    @Bean
    public Queue directQueue1() {
        return new Queue(QUEUE1, true);
    }
    @Bean
    public Queue directQueue2() {
        return new Queue(QUEUE2, true);
    }
}
