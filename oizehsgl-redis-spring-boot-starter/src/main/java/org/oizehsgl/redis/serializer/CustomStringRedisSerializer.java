package org.oizehsgl.redis.serializer;

import jakarta.annotation.Resource;
import java.util.Objects;
import org.oizehsgl.redis.properties.CustomRedisProperties;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class CustomStringRedisSerializer extends StringRedisSerializer {
  @Resource private CustomRedisProperties customRedisProperties;

  @Override
  public String deserialize(@Nullable byte[] bytes) {
    String string = super.deserialize(bytes);
    return Objects.isNull(string)
        ? null
        : string.substring(customRedisProperties.getPrefix().length());
  }

  @Override
  public byte[] serialize(@Nullable String string) {
    byte[] bytes = super.serialize(customRedisProperties.getPrefix() + string);
    return Objects.isNull(bytes) ? null : bytes;
  }
}
