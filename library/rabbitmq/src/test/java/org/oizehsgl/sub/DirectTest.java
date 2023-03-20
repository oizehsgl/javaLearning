package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.direct.DirectProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * directTest
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@SpringBootTest
public class DirectTest {
    @Autowired
    private DirectProducer directProducer;

    @Test
    public void testDirect() {
        System.out.println(directProducer.sendMsg());
        System.out.println(directProducer.sendMsg());
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
