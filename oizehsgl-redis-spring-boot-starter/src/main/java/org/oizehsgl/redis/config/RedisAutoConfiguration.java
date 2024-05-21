package org.oizehsgl.redis.config;

import org.oizehsgl.redis.properties.CustomRedisProperties;
import org.oizehsgl.redis.serializer.CustomGenericJackson2JsonRedisSerializer;
import org.oizehsgl.redis.serializer.CustomStringRedisSerializer;
import org.oizehsgl.redis.template.CustomRedisTemplate;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author oizehsgl
 */
@AutoConfiguration
@PropertySource("classpath:oizehsgl-redis.properties")
public class RedisAutoConfiguration {

  @Import({
    CustomRedisTemplate.class,
    CustomStringRedisSerializer.class,
    CustomGenericJackson2JsonRedisSerializer.class,
  })
  public static class CustomRedisTemplateConfiguration {}

  @EnableConfigurationProperties({CustomRedisProperties.class})
  public static class CustomRedisPropertiesConfiguration {}
}
