package org.oizehsgl.spring.statemachine.service;

import lombok.extern.java.Log;
import org.oizehsgl.spring.statemachine.config.DemoStateMachineFactoryConfig;
import org.oizehsgl.spring.statemachine.enums.DemoEvent;
import org.oizehsgl.spring.statemachine.enums.DemoState;
import org.oizehsgl.spring.statemachine.persist.redis.runtime.RedisDemoStateMachineRuntimePersister;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.service.DefaultStateMachineService;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class DemoStateMachineService extends DefaultStateMachineService<DemoState, DemoEvent> {
  public DemoStateMachineService(
      @Qualifier(DemoStateMachineFactoryConfig.LABEL)
          StateMachineFactory<DemoState, DemoEvent> stateMachineFactory,
      @Qualifier(RedisDemoStateMachineRuntimePersister.BEAN_NAME)
          StateMachinePersist<DemoState, DemoEvent, String> stateMachinePersist) {
    super(stateMachineFactory, stateMachinePersist);
  }
}
