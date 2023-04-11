package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.async.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * asyncTest
 *
 * @author oizehsgl
 * @since 4/11/23
 */
@SpringBootTest
public class AsyncTest {
    @Autowired
    private AsyncService asyncService;

    @Test
    public void testAsync() throws InterruptedException {
        int size = 16;
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            int finalI = i;
            threadList.add(
                    new Thread(() -> {
                        asyncService.async(finalI);
                    })
            );
        }
        for (Thread thread : threadList) {
            TimeUnit.NANOSECONDS.sleep(1000000);
            thread.start();
        }
        TimeUnit.SECONDS.sleep(3);
    }
}