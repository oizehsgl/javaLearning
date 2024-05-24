package org.oizehsgl.sm.spring.statemachine.persist.map;

import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.persist.AbstractStateMachinePersister;
import org.springframework.stereotype.Component;

/**
 * Map状态机持久化实现
 *
 * @author oizehsgl
 */
@Component
public class CustomMapStateMachinePersister
    extends AbstractStateMachinePersister<CustomState, CustomEvent, String> {
  /**
   * Instantiates a new abstract state machine persister.
   *
   * @param stateMachinePersist the state machine persist
   */
  public CustomMapStateMachinePersister(
      @Qualifier(CustomMapStateMachinePersist.BEAN_NAME)
      StateMachinePersist<CustomState, CustomEvent, String> stateMachinePersist) {
    super(stateMachinePersist);
  }
}
