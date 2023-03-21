package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.headers.HeadersProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * headersTest
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@SpringBootTest
public class HeadersTest {
    @Autowired
    private HeadersProducer headersProducer;

    @Test
    public void testHeaders() throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            System.out.println(headersProducer.sendMsg());
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(headersProducer.sendMsg());
        });
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }
}
