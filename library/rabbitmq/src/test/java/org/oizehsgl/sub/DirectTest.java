package org.oizehsgl.sub;

import org.oizehsgl.sub.direct.DirectProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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

//    @Test
    public void testDirect() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<?> future1 = executor.submit(() -> {
            System.out.println(directProducer.sendMsg());
        });

        Future<?> future2 = executor.submit(() -> {
            System.out.println(directProducer.sendMsg());
        });
        future1.get();
        future2.get();
        executor.shutdown();
    }
}
