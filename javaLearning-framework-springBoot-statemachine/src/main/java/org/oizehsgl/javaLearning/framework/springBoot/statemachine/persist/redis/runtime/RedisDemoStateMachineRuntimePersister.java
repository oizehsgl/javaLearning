package org.oizehsgl.javaLearning.framework.springBoot.statemachine.persist.redis.runtime;

import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
import org.springframework.statemachine.data.redis.RedisPersistingStateMachineInterceptor;
import org.springframework.statemachine.data.redis.RedisStateMachineRepository;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class RedisDemoStateMachineRuntimePersister
    extends RedisPersistingStateMachineInterceptor<DemoState, DemoEvent, String> {
  public RedisDemoStateMachineRuntimePersister(
      RedisStateMachineRepository redisStateMachineRepository) {
    super(redisStateMachineRepository);
  }
}
