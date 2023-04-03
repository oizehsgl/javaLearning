package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * multiValueMapTest
 *
 * @author oizehsgl
 * @since 4/3/23
 */
@SpringBootTest
public class MultiValueMapTest {
    @Test
    public void testMultiValueMap(){
        MultiValueMap<Long,Long> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add(1L,1L);
        multiValueMap.add(1L,2L);
        multiValueMap.add(1L,3L);
        multiValueMap.add(2L,1L);
        multiValueMap.add(2L,2L);
        multiValueMap.add(3L,1L);
        System.out.println(multiValueMap);
        System.out.println(multiValueMap.get(1L));
        System.out.println(multiValueMap.get(2L));
        System.out.println(multiValueMap.get(3L));
    }
}
