package org.oizehsgl.sm.spring.statemachine.persist.redis.runtime;

import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.springframework.statemachine.data.redis.RedisPersistingStateMachineInterceptor;
import org.springframework.statemachine.data.redis.RedisStateMachineRepository;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class CustomRedisPersistingStateMachineInterceptor
    extends RedisPersistingStateMachineInterceptor<CustomState, CustomEvent, String> {
  public static final String BEAN_NAME = "customRedisPersistingStateMachineInterceptor";

  public CustomRedisPersistingStateMachineInterceptor(
      RedisStateMachineRepository redisStateMachineRepository) {
    super(redisStateMachineRepository);
  }
}
