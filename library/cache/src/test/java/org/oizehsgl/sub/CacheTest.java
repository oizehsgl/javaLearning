package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StopWatch;

/**
 * cacheTest
 *
 * @author oizehsgl
 * @since 4/7/23
 */
@SpringBootTest
public class CacheTest {
    @Autowired
    private ICacheDemoService cacheDemoService;

    @Test
    public void testCache1() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("1-1");
        cacheDemoService.listCache().stream().forEach(System.out::println);
        stopWatch.stop();
        stopWatch.start("1-2");
        cacheDemoService.listCache().stream().forEach(System.out::println);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }

    @Test
    public void testCache2() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("2-1");
        cacheDemoService.listCache().stream().forEach(System.out::println);
        stopWatch.stop();
        stopWatch.start("2-2");
        cacheDemoService.listCache().stream().forEach(System.out::println);
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}
