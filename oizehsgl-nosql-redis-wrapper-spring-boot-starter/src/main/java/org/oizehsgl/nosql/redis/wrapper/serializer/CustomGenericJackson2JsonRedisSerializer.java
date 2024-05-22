package org.oizehsgl.nosql.redis.wrapper.serializer;

import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class CustomGenericJackson2JsonRedisSerializer extends GenericJackson2JsonRedisSerializer {
  public CustomGenericJackson2JsonRedisSerializer() {
    super();
    // 使用Jackson提供的通用Serializer
    this.configure(
        objectMapperConfigurer -> {
          // 如果涉及到对java.time类型的序列化/反序列化,需要注册JavaTimeModule
          objectMapperConfigurer.registerModule(new JavaTimeModule());
        });
  }
}
