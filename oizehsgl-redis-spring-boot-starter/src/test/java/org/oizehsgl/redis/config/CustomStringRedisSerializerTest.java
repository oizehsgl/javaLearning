package org.oizehsgl.redis.config;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.redis.template.CustomRedisTemplate;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@SpringBootTest
class CustomStringRedisSerializerTest {
  @Resource private CustomRedisTemplate<String> customRedisTemplate;

  @Test
  public void test() {
    customRedisTemplate.opsForValue().set("key1", "value1");
    System.out.println(customRedisTemplate.opsForValue().get("key1"));
  }
}
