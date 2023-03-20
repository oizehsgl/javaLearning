package org.oizehsgl.sub.topic.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * topicQueue
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@Configuration
public class TopicQueueConfig {
    public final static String QUEUE1 = "topicQueue1";
    public final static String QUEUE2 = "topicQueue2";

    @Bean
    public Queue topicQueue1() {
        return new Queue(QUEUE1, true);
    }
    @Bean
    public Queue topicQueue2() {
        return new Queue(QUEUE2, true);
    }
}
