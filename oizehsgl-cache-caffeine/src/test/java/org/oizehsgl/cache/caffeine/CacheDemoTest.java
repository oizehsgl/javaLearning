package org.oizehsgl.cache.caffeine;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.annotation.Resource;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@SpringBootTest
class CacheDemoTest {
  @Resource private CacheDemo cacheDemo;

  @Test
  public void testCacheDemo() throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      System.out.println(cacheDemo.get("a"));
      TimeUnit.SECONDS.sleep(1);
    }
  }
}
