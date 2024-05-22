package org.oizehsgl.spring.statemachine.service;

import org.oizehsgl.spring.statemachine.factory.CustomStateMachineFactoryConfig;
import org.oizehsgl.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.spring.statemachine.enums.CustomState;
import org.oizehsgl.spring.statemachine.persist.redis.runtime.CustomRedisPersistingStateMachineInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.service.DefaultStateMachineService;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class CustomStateMachineService
    extends DefaultStateMachineService<CustomState, CustomEvent> {
  public CustomStateMachineService(
      @Qualifier(CustomStateMachineFactoryConfig.FACTORY_NAME)
          StateMachineFactory<CustomState, CustomEvent> stateMachineFactory,
      @Qualifier(CustomRedisPersistingStateMachineInterceptor.BEAN_NAME)
          StateMachinePersist<CustomState, CustomEvent, String> stateMachinePersist) {
    super(stateMachineFactory, stateMachinePersist);
  }
}
