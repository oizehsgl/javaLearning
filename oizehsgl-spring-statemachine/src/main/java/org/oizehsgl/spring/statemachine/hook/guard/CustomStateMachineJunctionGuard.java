package org.oizehsgl.spring.statemachine.hook.guard;

import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.spring.statemachine.enums.CustomState;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.guard.Guard;
import org.springframework.stereotype.Component;

/**
 * 状态机保护
 *
 * @author oizehsgl
 */
@Slf4j
@Component
public class CustomStateMachineJunctionGuard implements Guard<CustomState, CustomEvent> {
  @Override
  public boolean evaluate(StateContext<CustomState, CustomEvent> context) {
    log.info(
        "状态机守卫(联结)[现态<{}>,次态<{}>]", context.getSource().getIds(), context.getTarget().getIds());
    return true;
  }
}
