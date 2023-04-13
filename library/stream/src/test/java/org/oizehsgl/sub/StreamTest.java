package org.oizehsgl.sub;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StopWatch;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
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

    /**
     * 日志包装器
     *
     * @param consumer 消费者
     * @param <T>      泛型
     * @return 异常捕获并输出日志的消费者
     */
    private <T> Consumer<T> logWrapper(Consumer<T> consumer) {
        return t -> {
            try {
                System.out.println("consumer");
                consumer.accept(t);
            } catch (Exception e) {
                log.warn(e.getMessage(), e);
            }
        };
    }

    /**
     * 日志包装器
     *
     * @param function 函数
     * @param <T>      泛型
     * @return 异常捕获并输出日志的函数
     */
    private <T, R> Function<T, R> logWrapper(Function<T, R> function) {
        return t -> {
            try {
                System.out.println("function");
                return function.apply(t);
            } catch (Exception e) {
                log.warn(e.getMessage(), e);
            }
            return null;
        };
    }

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
        System.out.println(streamDemoList.stream().collect(Collectors.partitioningBy(s -> s.getInteger() > 2)));
        System.out.println(streamDemoList.stream().collect(Collectors.groupingBy(StreamDemo::getInteger, Collectors.groupingBy(StreamDemo::getString))));
        System.out.println(String.valueOf(streamDemoList.stream().collect(Collectors.groupingBy(StreamDemo::getInteger, LinkedMultiValueMap::new, Collectors.mapping(e -> e.getInteger() + 1, Collectors.toList())))));
        System.out.println(streamDemoList.stream().map(StreamDemo::getString).collect(Collectors.joining("--", "<<", ">>")));
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
    public void testTryStream() {
        Stream.iterate(0, i -> i + 1).limit(3).map(logWrapper(i -> i == i)).forEach(logWrapper(i -> {
            System.out.println(i);
        }));
        Stream.iterate(0, i -> i + 1).limit(3).forEach(logWrapper((Integer i) -> System.out.println(i)));
    }

    @Test
    public void testGroupingBy() {
        List<Integer> integers1 = Stream.iterate(0, e -> e + 1).limit(5).collect(Collectors.toList());
        List<Integer> integers2 = Stream.iterate(0, e -> 2 * e + 1).limit(5).collect(Collectors.toList());
        List<Integer> integers = Stream.of(integers1.stream(), integers2.stream()).flatMap(e -> e).collect(Collectors.toList());
        integers.stream().forEach(System.out::println);
        integers = integers.stream().sorted(Comparator.comparing(e -> e + 1)).collect(Collectors.toList());
        Map<Integer, List<Integer>> integerListMap = integers.stream().sorted(Comparator.comparing(e -> e)).collect(Collectors.groupingBy(e -> e, Collectors.mapping(e -> e + 1, Collectors.toList())));
        System.out.println(integerListMap);
    }

    @Test
    public void testSorted() {
        List<Integer> integers = Stream.iterate(10, e -> e - 1).limit(5).collect(Collectors.toList());
        integers.stream().sorted(Comparator.comparing(e -> e + 1, Comparator.reverseOrder())).forEach(System.out::println);
        integers.stream().sorted(Comparator.comparing(e -> e + 1)).forEach(System.out::println);
        integers.stream().sorted(Comparator.comparing((Integer e) -> e + 1).reversed()).forEach(System.out::println);
        integers.stream().sorted((e1, e2) -> e2 - e1).forEach(System.out::println);
    }

    @Test
    public void testSingle() {
        Integer integer = null;
        Stream.of(integer).map(e -> "-" + e).forEach(System.out::println);
    }

    @Test
    public void testReduce() {
        List<String> props = List.of("k1=v1", "k2=v2", "k3=v3");
        Map<String, String> map = props.stream().map(kv -> {
            String[] ss = kv.split("=", 2);
            return Map.of(ss[0], ss[1]);
        }).reduce(new HashMap<String, String>(), (m, kv) -> {
            m.putAll(kv);
            return m;
        });

        map.forEach((k, v) -> {
            System.out.println(k);
            System.out.println(v);
        });

    }

    @Test
    public void testReduce2() {
        List<Integer> integerList = Stream.iterate(0, i -> i + 1).limit(10).toList();
        System.out.println(integerList.stream().reduce(1, (seed, e) -> seed + e));
        System.out.println(integerList.stream().parallel().reduce(1, (seed, e) -> seed + e));
    }

    @Test
    public void testReduces() {
        int size = 9;
        int length = 5;
        List<List<Integer>> listList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            listList.add(Stream.iterate(0, x -> x + 1).limit(length).toList());
        }
        List<Integer> integers1 = Stream.iterate(0, x -> x + 1).limit(3).toList();
        List<Integer> integers2 = Stream.iterate(0, x -> x + 1).limit(3).toList();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("0");
        List<List<Integer>> listList0 = cartesianProduct0(listList);
        //System.out.println(listList0);
        stopWatch.stop();
        stopWatch.start("1");
        List<List<Integer>> listList1 = cartesianProduct1(listList);
        //System.out.println(listList1);
        stopWatch.stop();
        stopWatch.start("2");
        List<List<Integer>> listList2 = cartesianProduct2(listList);
        //System.out.println(listList2);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

    }

    private <T> List<List<T>> cartesianProduct0(List<List<T>> lists) {
        List<List<T>> product = new ArrayList<>();
        for (List<T> list : lists) {
            if (ObjectUtils.isEmpty(product)) {
                for (T t : list) {
                    List<T> tList = new ArrayList<>();
                    tList.add(t);
                    product.add(tList);
                }
            } else {
                List<List<T>> listList = new ArrayList<>();
                for (List<T> tList : product) {
                    for (T t : list) {
                        List<T> tListCopy = new ArrayList<>(tList);
                        tListCopy.add(t);
                        listList.add(tListCopy);
                    }
                }
                product=listList;
            }
        }
        return product;
    }

    private <T> List<List<T>> cartesianProduct1(List<List<T>> lists) {
        List<List<T>> product = new ArrayList<>();
        for (List<T> list : lists) {
            if (ObjectUtils.isEmpty(product)) {
                list.stream().map(Collections::singletonList).forEach(product::add);
            } else {
                product = product.stream().flatMap(e -> list.stream().map(e1 -> {
                    List<T> tList = new ArrayList<>(e);
                    tList.add(e1);
                    return tList;
                })).collect(Collectors.toList());
            }
        }
        return product;
    }

    private <T> List<List<T>> cartesianProduct2(List<List<T>> lists) {
        List<List<T>> product = new ArrayList<>();
        for (List<T> list : lists) {
            if (ObjectUtils.isEmpty(product)) {
                list.stream().map(Collections::singletonList).forEach(product::add);
            } else {
                product = product.stream().flatMap(e -> list.stream().map(e1 -> Stream.concat(e.stream(), Stream.of(e1)).collect(Collectors.toList()))).collect(Collectors.toList());
            }
        }
        return product;
    }

    private <T> List<List<T>> cartesianProduct(List<T>... lists) {
        List<List<T>> product = new ArrayList<>();
        for (List<T> list : lists) {
            if (ObjectUtils.isEmpty(product)) {
                list.stream().map(Collections::singletonList).forEach(product::add);
            } else {
                product = product.stream().flatMap(e -> list.stream().map(e1 -> {
                    List<T> tList = new ArrayList<>(e);
                    tList.add(e1);
                    return tList;
                })).collect(Collectors.toList());
            }
        }
        return product;
    }

    @Test
    public void testReduce3() {
        List<Integer> integerList = Stream.iterate(0, i -> i + 1).limit(10).toList();
        System.out.println(integerList.stream().reduce(0, (seed, e) -> seed + e, (e1, e2) -> e1 + e2));
        System.out.println(integerList.stream().parallel().reduce(0, (seed, e) -> seed + e, (e1, e2) -> e1 + e2));
        System.out.println(integerList.stream().reduce(1, (seed, e) -> seed + e, (e1, e2) -> e1 + e2));
        System.out.println(integerList.stream().parallel().reduce(1, (seed, e) -> seed + e, (e1, e2) -> e1 + e2));
    }
}
