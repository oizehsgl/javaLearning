package org.oizehsgl.sm.spring.statemachine.persist.redis;

import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.data.redis.RedisStateMachinePersister;
import org.springframework.stereotype.Component;

/**
 * Redis状态机持久化实现
 *
 * @author oizehsgl
 */
@Component
public class CustomRedisStateMachinePersister
    extends RedisStateMachinePersister<CustomState, CustomEvent> {
  public CustomRedisStateMachinePersister(
      // @Qualifier("customRedisPersistingStateMachineInterceptor")
      @Qualifier(CustomRedisRepositoryStateMachinePersist.BEAN_NAME)
      StateMachinePersist<CustomState, CustomEvent, String> stateMachinePersist) {
    super(stateMachinePersist);
  }
}
