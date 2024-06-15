package org.oizehsgl.sm.spring.statemachine.factory;

import jakarta.annotation.Resource;
import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.oizehsgl.sm.spring.statemachine.persist.redis.CustomRedisStateMachinePersister;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class CustomStateMachineWrapperFactory
    implements KeyedFactoryBean<String, CustomStateMachineWrapper> {

  @Resource(name = CustomStateMachineFactoryConfig.BEAN_NAME)
  private StateMachineFactory<CustomState, CustomEvent> stateMachineFactory;

  @Resource private CustomRedisStateMachinePersister customRedisStateMachinePersister;

  @Override
  public CustomStateMachineWrapper getObject(String s) {
    return CustomStateMachineWrapper.builder()
        .stateMachine(stateMachineFactory.getStateMachine(s))
        .customRedisStateMachinePersister(customRedisStateMachinePersister)
        .build();
  }
}
