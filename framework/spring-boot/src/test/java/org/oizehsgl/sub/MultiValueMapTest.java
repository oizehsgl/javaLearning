package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * multiValueMapTest
 *
 * @author oizehsgl
 * @since 4/3/23
 */
@SpringBootTest
public class MultiValueMapTest {
    @Test
    public void testMultiValueMap() {
        MultiValueMap<Long, Long> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add(1L, 1L);
        multiValueMap.add(1L, 2L);
        multiValueMap.add(1L, 3L);
        multiValueMap.add(2L, 1L);
        multiValueMap.add(2L, 2L);
        multiValueMap.add(3L, 1L);
        System.out.println(multiValueMap);
        System.out.println(multiValueMap.get(1L));
        System.out.println(multiValueMap.get(2L));
        System.out.println(multiValueMap.get(3L));
    }

    @Test
    public void testStream() {
        List<Long> longList = Stream.of(1, 1, 1, 2, 2, 3).map(Integer::longValue).collect(Collectors.toList());
        MultiValueMap<Long, Long> multiValueMap=longList.stream().collect(Collectors.groupingBy(e->e+1,LinkedMultiValueMap::new,Collectors.toList()));
        System.out.println(multiValueMap);
    }
}
