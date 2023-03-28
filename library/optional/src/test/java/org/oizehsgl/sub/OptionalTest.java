package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ObjectUtils;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * optionalTest
 *
 * @author oizehsgl
 * @since 3/28/23
 */
@SpringBootTest
public class OptionalTest {
    @Test
    public void testOptional() {
        List<Integer> integerList = Arrays.asList(1, 2, null, 4);
        Queue<String> exceptionStackTraceHeadQueue = new ConcurrentLinkedQueue<>();
        Optional.ofNullable(integerList).orElse(new ArrayList<>())
                .stream().map(Optional::ofNullable)
                .parallel()
                .forEach(optionalInteger -> {
                    try {
                        optionalInteger.orElseThrow(RuntimeException::new);
                    } catch (Exception e) {
                        if (Objects.isNull(e.getMessage())) {
                            exceptionStackTraceHeadQueue.add(optionalInteger.map(Long::valueOf).map(String::valueOf).orElse("") + e.getStackTrace()[1]);
                        } else {
                            exceptionStackTraceHeadQueue.add(optionalInteger.map(Long::valueOf).map(String::valueOf).orElse("") + e.getStackTrace()[0]);
                        }
                    }
                });
        if (!ObjectUtils.isEmpty(exceptionStackTraceHeadQueue)) {
            System.out.println(exceptionStackTraceHeadQueue);
        }
    }
}
