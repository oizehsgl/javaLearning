package org.oizehsgl.nosql.redis;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.nosql.redis.wrapper.template.CustomRedisTemplate;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OizehsglNosqlRedisApplicationTests {

  @Resource private CustomRedisTemplate<String> customRedisTemplate;

  @Test
  void contextLoads() {
    customRedisTemplate.opsForValue().set("key1", "value1");
    System.out.println(customRedisTemplate.opsForValue().get("key1"));
  }
}
