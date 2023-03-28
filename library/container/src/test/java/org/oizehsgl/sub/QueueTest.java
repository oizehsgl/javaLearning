package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * QueueTest
 *
 * @author oizehsgl
 * @since 3/28/23
 */
@SpringBootTest
public class QueueTest {
    @Test
    public void testLinkedBlockingQueue() {
        Queue<Integer> queue = new LinkedBlockingQueue<>();
        Stream.iterate(0, i -> i + 1).limit(100).parallel().forEach(queue::add);
        System.out.println(queue.size());
    }

    @Test
    public void testArrayBlockingQueue() {
        Queue<Integer> queue = new ArrayBlockingQueue<>(100);
        Stream.iterate(0, i -> i + 1).limit(100).parallel().forEach(queue::add);
        System.out.println(queue.size());
    }


    @Test
    public void testArrayDeque() {
        Queue<Integer> queue = new ArrayDeque<>();
        Stream.iterate(0, i -> i + 1).limit(100).parallel().forEach(queue::add);
        System.out.println(queue.size());
    }

    @Test
    public void testPriorityQueue() {
        Queue<Integer> queue = new PriorityQueue<>();
        Stream.iterate(0, i -> i + 1).limit(100).parallel().forEach(queue::add);
        System.out.println(queue.size());
    }

    @Test
    public void testSynchronousQueue() throws InterruptedException {
        SynchronousQueue<Integer> queue = new SynchronousQueue<>();
        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producer is putting 1");
                queue.put(1);
                System.out.println("Producer has put 1");
                System.out.println("Producer is putting 2");
                queue.put(2);
                System.out.println("Producer has put 2");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                System.out.println("Consumer is taking from queue");
                Integer item1 = queue.take();
                System.out.println("Consumer has taken " + item1);
                System.out.println("Consumer is taking from queue");
                Integer item2 = queue.take();
                System.out.println("Consumer has taken " + item2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        producer.start();
        TimeUnit.SECONDS.sleep(3);
        consumer.start();
        producer.join();
        consumer.join();
    }

    @Test
    public void testConcurrentLinkedQueue() {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();
        Stream.iterate(0, i -> i + 1).limit(100).parallel().forEach(queue::add);
        System.out.println(queue.size());
    }
}
