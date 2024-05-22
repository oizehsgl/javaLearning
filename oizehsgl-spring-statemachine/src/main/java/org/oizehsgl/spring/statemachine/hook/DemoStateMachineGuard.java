package org.oizehsgl.spring.statemachine.hook;

import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.spring.statemachine.enums.DemoEvent;
import org.oizehsgl.spring.statemachine.enums.DemoState;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.guard.Guard;
import org.springframework.stereotype.Component;

/**
 * 订单状态机保护
 *
 * @author oizehsgl
 */
@Slf4j
@Component
public class DemoStateMachineGuard implements Guard<DemoState, DemoEvent> {
  @Override
  public boolean evaluate(StateContext<DemoState, DemoEvent> context) {
    log.info(
        "状态机守护触发[source<{}>,target<{}>]", context.getSource().getId(), context.getTarget().getId());
    return true;
  }
}
