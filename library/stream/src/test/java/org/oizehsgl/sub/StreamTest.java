package org.oizehsgl.sub;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * streamTest
 *
 * @author oizehsgl
 * @since 3/23/23
 */
@Slf4j
@SpringBootTest
public class StreamTest {
    private static List<StreamDemo> streamDemoList;

    @BeforeEach
    public void init() {
        streamDemoList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StreamDemo streamDemo = StreamDemo.builder().integer(i).string(String.valueOf(i)).character((char) i).build();
            streamDemoList.add(streamDemo);
        }
    }

    @Test
    public void testStart() {
        streamDemoList.stream().forEach(System.out::println);
        streamDemoList.parallelStream().forEach(System.out::println);
        Stream.of(1, 2, 3).forEach(System.out::println);
        Stream.iterate(0, x -> x + 3).limit(5).forEach(System.out::println);
        Stream.generate(Math::random).limit(3).forEach(System.out::println);
    }

    @Test
    public void testMiddle() {
        streamDemoList.stream()
                .filter(s -> s.getInteger() > 2)
                .map(s -> s.getInteger())
                .flatMap(s -> Stream.of(s + 1, s + 2))
                .limit(10)
                .skip(3)
                .distinct()
                .sorted((s1, s2) -> s2 - s1)
                .peek(s -> System.out.printf(String.valueOf(s)))
                .parallel()
                .sequential()
                .unordered()
                .peek(s -> System.out.printf(String.valueOf(s)))
                .forEach(System.out::println);
    }

    @Test
    public void testEnd() {
        System.out.println(streamDemoList.stream().count());
        System.out.println(streamDemoList.stream().max(Comparator.comparingInt(StreamDemo::getInteger)));
        System.out.println(streamDemoList.stream().min(Comparator.comparingInt(StreamDemo::getInteger)));
        System.out.println(streamDemoList.stream().findFirst());
        System.out.println(streamDemoList.stream().findAny());
        System.out.println(streamDemoList.parallelStream().findAny());
        System.out.println(streamDemoList.stream().anyMatch(s -> s.getInteger() > 5));
        System.out.println(streamDemoList.stream().allMatch(s -> s.getInteger() > 5));
        System.out.println(streamDemoList.stream().noneMatch(s -> s.getInteger() > 5));
        System.out.println(Arrays.toString(streamDemoList.stream().toArray()));
        System.out.println(Arrays.toString(streamDemoList.stream().toArray(StreamDemo[]::new)));
        System.out.println(streamDemoList.stream().iterator());
        streamDemoList.stream().forEach(System.out::println);
        System.out.println(streamDemoList.stream().collect(Collectors.toMap(s -> s.getInteger(), s -> s, (s1, s2) -> s2)));
        System.out.println(streamDemoList.stream().reduce((x, y) -> {
            x.setInteger(x.getInteger() + y.getInteger());
            return x;
        }));
        System.out.println(streamDemoList.stream().reduce(StreamDemo.builder().integer(1000).build(),(x, y) -> {
            x.setInteger(x.getInteger() + y.getInteger());
            return x;
        }));
    }
    @Test
    public void testCollect() {
        System.out.println(streamDemoList.stream().collect(Collectors.averagingDouble(StreamDemo::getInteger)));
        System.out.println(streamDemoList.stream().collect(Collectors.partitioningBy(s->s.getInteger()>2)));
        System.out.println(streamDemoList.stream().collect(Collectors.groupingBy(StreamDemo::getInteger, Collectors.groupingBy(StreamDemo::getString))));
        System.out.println(streamDemoList.stream().map(StreamDemo::getString).collect(Collectors.joining("---")));
    }

    @Test
    public void testNpe() {
        class Tmp {
            private Integer integer;

            public Integer getInteger() {
                return integer;
            }

            public Tmp(Integer integer) {
                this.integer = integer;
            }
        }
        List<Tmp> integerList = Arrays.asList(new Tmp(1), new Tmp(2), null, new Tmp(null));
        integerList.stream()
                .filter(Objects::nonNull)
                .map(Tmp::getInteger)
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(Integer::intValue).reversed())
                .forEach(System.out::println);
    }

    @Test
    public void testOptional() {
        Stream.iterate(0, i -> i + 1).limit(3).forEach(System.out::println);
        Stream.iterate(0, i -> i + 1).limit(3).map(Optional::ofNullable).forEach(System.out::println);
        Stream.of(1,2,null).map(Optional::ofNullable).forEach(logWrapper(i->i.orElseThrow(RuntimeException::new)));
    }

    private <T> Consumer<T> logWrapper(Consumer<T> consumer) {
        return t -> {
            try {
                consumer.accept(t);
            } catch (Exception e) {
                log.warn(e.getMessage(), e);
            }
        };
    }
}
