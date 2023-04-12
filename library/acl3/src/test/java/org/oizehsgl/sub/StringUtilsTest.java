package org.oizehsgl.sub;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

/**
 * stringUtilsTest
 *
 * @author oizehsgl
 * @since 4/12/23
 */
@SpringBootTest
public class StringUtilsTest {
    @Test
    public void testSplit(){
        Stream.of(StringUtils.split("a,b.c", ",|.")).forEach(System.out::println);
    }
}
