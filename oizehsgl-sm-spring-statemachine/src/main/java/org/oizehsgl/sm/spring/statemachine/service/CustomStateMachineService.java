package org.oizehsgl.sm.spring.statemachine.service;

import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.service.StateMachineService;
import org.springframework.stereotype.Service;

/**
 * @author oizehsgl
 */
@Service
public class CustomStateMachineService implements StateMachineService<CustomState, CustomEvent> {



  @Override
  public StateMachine<CustomState, CustomEvent> acquireStateMachine(String machineId) {
    return acquireStateMachine(machineId, Boolean.FALSE);
  }

  @Override
  public StateMachine<CustomState, CustomEvent> acquireStateMachine(
      String machineId, boolean start) {
    return null;
  }

  @Override
  public void releaseStateMachine(String machineId) {
    releaseStateMachine(machineId, Boolean.FALSE);
  }

  @Override
  public void releaseStateMachine(String machineId, boolean stop) {}
}
