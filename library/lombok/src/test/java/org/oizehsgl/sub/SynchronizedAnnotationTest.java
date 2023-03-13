package org.oizehsgl.sub;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oizehsgl
 * @since 3/13/23
 */
public class SynchronizedAnnotationTest {

    @Test
    public void testAddInteger() throws InterruptedException {
        SynchronizedAnnotation synchronizedAnnotation = new SynchronizedAnnotation();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    synchronizedAnnotation.addInteger();
                }
            });
            threadList.add(thread);
        }
        for (Thread thread : threadList) {
            thread.start();
        }
        for (Thread thread : threadList) {
            thread.join();
        }
        System.out.println("SynchronizedAnnotation.integer = " + SynchronizedAnnotation.integer);
    }
}