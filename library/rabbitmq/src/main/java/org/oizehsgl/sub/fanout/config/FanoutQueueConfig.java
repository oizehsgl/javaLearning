package org.oizehsgl.sub.fanout.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * fanoutQueueConfig
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Configuration
public class FanoutQueueConfig {
    public final static String QUEUE1 = "fanoutQueue1";
    public final static String QUEUE2 = "fanoutQueue2";

    @Bean
    public Queue fanoutQueue1() {
        return new Queue(QUEUE1, true);
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue(QUEUE2, true);
    }
}
