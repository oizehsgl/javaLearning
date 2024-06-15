package org.oizehsgl.sm.spring.statemachine.persist.redis;

import jakarta.annotation.Resource;
import java.util.Objects;
import org.oizehsgl.sm.spring.statemachine.property.ThisCustomRedisProperties;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class CustomStateMachineStringRedisSerializer extends StringRedisSerializer {

  public static final String BEAN_NAME = "customStateMachineStringRedisSerializer";

  @Resource private ThisCustomRedisProperties thisCustomRedisProperties;

  @Override
  public String deserialize(@Nullable byte[] bytes) {
    String string = super.deserialize(bytes);
    return Objects.isNull(string)
        ? null
        : string.substring(thisCustomRedisProperties.getStateMachine().getPrefix().length());
  }

  @Override
  public byte[] serialize(@Nullable String string) {
    byte[] bytes =
        super.serialize(
            String.format("%s%s", thisCustomRedisProperties.getStateMachine().getPrefix(), string));
    return Objects.isNull(bytes) ? null : bytes;
  }
}
