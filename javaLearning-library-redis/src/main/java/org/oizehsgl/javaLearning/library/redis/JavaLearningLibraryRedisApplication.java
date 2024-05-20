package org.oizehsgl.javaLearning.library.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class JavaLearningLibraryRedisApplication {

  public static void main(String[] args) {
    SpringApplication.run(JavaLearningLibraryRedisApplication.class, args);
  }
}
