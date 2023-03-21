package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.topic.TopicProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CountDownLatch;

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
    public void testTopic() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {
            System.out.println(topicProducer.sendMsg());
            latch.countDown();
        }).start();
        new Thread(() -> {
            System.out.println(topicProducer.sendMsg());
            latch.countDown();
        }).start();

        latch.await();
    }
}
