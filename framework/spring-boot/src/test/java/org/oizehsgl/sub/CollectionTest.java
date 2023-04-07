package org.oizehsgl.sub;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

import java.util.List;
import java.util.Set;
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
}
