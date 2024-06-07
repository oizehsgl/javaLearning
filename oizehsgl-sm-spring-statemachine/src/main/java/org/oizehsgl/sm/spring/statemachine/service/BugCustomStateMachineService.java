package org.oizehsgl.sm.spring.statemachine.service;

import jakarta.annotation.Resource;
import org.oizehsgl.nosql.redis.wrapper.template.CustomRedisTemplate;
import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.oizehsgl.sm.spring.statemachine.factory.CustomStateMachineFactoryConfig;
import org.oizehsgl.sm.spring.statemachine.persist.redis.runtime.CustomRedisPersistingStateMachineInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.service.DefaultStateMachineService;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author oizehsgl
 */
@Component
public class BugCustomStateMachineService
    extends DefaultStateMachineService<CustomState, CustomEvent> {
  private final StateMachinePersist<CustomState, CustomEvent, String> stateMachinePersist;
  private final StateMachineFactory<CustomState, CustomEvent> stateMachineFactory;

  @Resource
  private CustomRedisTemplate<StateMachineContext<CustomState, CustomEvent>> customRedisTemplate;

  public BugCustomStateMachineService(
      @Qualifier(CustomStateMachineFactoryConfig.FACTORY_NAME)
          StateMachineFactory<CustomState, CustomEvent> stateMachineFactory,
      @Qualifier(CustomRedisPersistingStateMachineInterceptor.BEAN_NAME)
          StateMachinePersist<CustomState, CustomEvent, String> stateMachinePersist) {
    super(stateMachineFactory, stateMachinePersist);
    this.stateMachinePersist = stateMachinePersist;
    this.stateMachineFactory = stateMachineFactory;
  }

  public void clear(String machineId) {
    // stateMachineFactory.getStateMachine(machineId);
    // stateMachinePersist.write(, machineId);
    // String key ="FSM:" + machineId+"*";
    String key = "*";
    Set<String> keySet = customRedisTemplate.keys(key);
    customRedisTemplate.delete(keySet);
  }
}
