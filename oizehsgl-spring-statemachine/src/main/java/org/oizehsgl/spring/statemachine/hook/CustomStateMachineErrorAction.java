package org.oizehsgl.spring.statemachine.hook;

import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.spring.statemachine.enums.CustomState;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

/**
 * 状态机异常动作
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
        "状态机动作异常触发[source<{}>,target<{}>]",
        context.getSource().getId(),
        context.getTarget().getId(),
        e);
  }
}
