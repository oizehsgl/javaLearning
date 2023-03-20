package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.topic.TopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * topicTest
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@SpringBootTest
public class TopicTest {
    @Autowired
    private TopicProducer topicProducer;

    @Test
    public void testTopic() {
        System.out.println(topicProducer.sendMsg());
        System.out.println(topicProducer.sendMsg());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
