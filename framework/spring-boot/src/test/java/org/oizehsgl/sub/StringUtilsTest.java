package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * stringUtlisTest
 *
 * @author oizehsgl
 * @since 4/3/23
 */
@SpringBootTest
public class StringUtilsTest {
    @Test
    public void testStringUtilsTest() {
        List<Long> longList = Stream.iterate(0,i->i+1).limit(3).map(Long::valueOf).collect(Collectors.toList());
        System.out.println(StringUtils.collectionToCommaDelimitedString(longList));
        System.out.println(StringUtils.collectionToDelimitedString(longList,"|"));
        System.out.println(StringUtils.collectionToDelimitedString(longList,"--","<<",">>"));

    }
}
