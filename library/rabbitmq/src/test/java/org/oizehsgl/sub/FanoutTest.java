package org.oizehsgl.sub;

import org.oizehsgl.sub.fanout.FanoutProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

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

//    @Test
    public void testFanout() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            System.out.println(fanoutProducer.sendMsg());
        });
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            System.out.println(fanoutProducer.sendMsg());
        });
        CompletableFuture.allOf(future1, future2).get();
    }
}
