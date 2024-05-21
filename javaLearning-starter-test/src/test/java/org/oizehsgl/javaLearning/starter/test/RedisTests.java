package org.oizehsgl.javaLearning.starter.test;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.redis.template.CustomRedisTemplate;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@SpringBootTest
public class RedisTests {
  @Resource private CustomRedisTemplate<Object> customRedisTemplate;

  @Test
  public void test() {
    customRedisTemplate.opsForValue().set("hello", "world");
    System.out.println(customRedisTemplate.opsForValue().get("hello"));
  }
}
