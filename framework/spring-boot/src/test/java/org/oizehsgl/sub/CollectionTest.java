package org.oizehsgl.sub;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * collectionTest
 *
 * @author oizehsgl
 * @since 4/7/23
 */
@SpringBootTest
public class CollectionTest {
    int size = 10000;
    List<Integer> integerList;
    Set<Integer> integerSet;

    @BeforeEach
    public void init() {
        integerList = Stream.iterate(0, x -> x + 1).limit(size).collect(Collectors.toList());
        integerSet = Stream.iterate(0, x -> x + 1).limit(size).collect(Collectors.toSet());
    }

    @Test
    public void testContains() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(List.class.getSimpleName());
        System.out.println(integerList.contains(size));
        stopWatch.stop();
        stopWatch.start(Set.class.getSimpleName());
        System.out.println(integerSet.contains(size));
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    @Test
    public void testForeach() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(List.class.getSimpleName());
        System.out.println(integerList.stream().filter(e -> e == size).findFirst());
        stopWatch.stop();
        stopWatch.start(Set.class.getSimpleName());
        System.out.println(integerSet.stream().filter(e -> e == size).findFirst());
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    @Test
    public void testLinkedList() {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        integerLinkedList.add(1);
        integerLinkedList.add(2);
        integerLinkedList.addFirst(3);
        integerLinkedList.addLast(4);
        System.out.println(integerLinkedList.peek());
        System.out.println(integerLinkedList.poll());
        System.out.println(integerLinkedList.pop());
        System.out.println();
        for (Integer integer : integerLinkedList) {
            System.out.println(integer);
        }
    }

    @Test
    public void testQueue() {
        Queue<Integer> integerQueue = new LinkedBlockingQueue<>();
        integerQueue.add(1);
        integerQueue.add(2);
        integerQueue.add(3);
        integerQueue.add(4);
        System.out.println(integerQueue.peek());
        System.out.println(integerQueue.poll());
        for (Integer integer : integerQueue) {
            System.out.println(integer);
        }
    }

    @Test
    public void testDequeue() {
        Deque<Integer> integerDeque = new LinkedBlockingDeque<>();
        integerDeque.add(1);
        integerDeque.add(2);
        integerDeque.addFirst(3);
        integerDeque.addLast(4);
        System.out.println(integerDeque.peek());
        System.out.println(integerDeque.poll());
        System.out.println(integerDeque.pop());
        System.out.println();
        for (Integer integer : integerDeque) {
            System.out.println(integer);
        }
    }

    @Test
    public void testStack() {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.add(1);
        integerStack.add(2);
        integerStack.push(3);
        integerStack.push(4);
        System.out.println(integerStack.peek());
        System.out.println(integerStack.pop());
        for (Integer integer : integerStack) {
            System.out.println(integer);
        }
        System.out.println(integerStack);
    }
}
