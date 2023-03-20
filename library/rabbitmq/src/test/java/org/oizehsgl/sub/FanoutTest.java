package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.fanout.FanoutProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * fanoutTest
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@SpringBootTest
public class FanoutTest {
    @Autowired
    private FanoutProducer fanoutProducer;

    @Test
    public void testFanout() {
        System.out.println(fanoutProducer.sendMsg());
        System.out.println(fanoutProducer.sendMsg());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
