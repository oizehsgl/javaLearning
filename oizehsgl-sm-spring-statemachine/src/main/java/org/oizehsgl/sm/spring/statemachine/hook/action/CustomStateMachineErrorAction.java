package org.oizehsgl.sm.spring.statemachine.hook.action;

import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

/**
 * 状态机异常行动
 *
 * @author oizehsgl
 */
@Slf4j
@Component
public class CustomStateMachineErrorAction implements Action<CustomState, CustomEvent> {
  @Override
  public void execute(StateContext<CustomState, CustomEvent> context) {
    Exception e = context.getException();
    log.error(
        "状态机行动(异常)[现态<{}>,次态<{}>]", context.getSource().getId(), context.getTarget().getId(), e);
  }
}
