package org.oizehsgl.nosql.redis.wrapper.config;

import org.oizehsgl.nosql.redis.wrapper.properties.CustomRedisProperties;
import org.oizehsgl.nosql.redis.wrapper.serializer.CustomGenericJackson2JsonRedisSerializer;
import org.oizehsgl.nosql.redis.wrapper.serializer.CustomStringRedisSerializer;
import org.oizehsgl.nosql.redis.wrapper.template.CustomRedisTemplate;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * @author oizehsgl
 */
@AutoConfiguration
@PropertySource("classpath:oizehsgl-nosql-redis-wrapper.properties")
public class NosqlRedisWrapperAutoConfiguration {

  @Import({
    CustomRedisTemplate.class,
    CustomStringRedisSerializer.class,
    CustomGenericJackson2JsonRedisSerializer.class,
  })
  public static class CustomRedisTemplateConfiguration {}

  @EnableConfigurationProperties({CustomRedisProperties.class})
  public static class CustomRedisPropertiesConfiguration {}
}
