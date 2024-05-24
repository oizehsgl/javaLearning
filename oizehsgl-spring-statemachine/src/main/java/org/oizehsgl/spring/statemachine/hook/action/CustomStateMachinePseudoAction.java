package org.oizehsgl.spring.statemachine.hook.action;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.spring.statemachine.enums.CustomState;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.state.State;
import org.springframework.stereotype.Component;

/**
 * 状态机行动
 *
 * @author oizehsgl
 */
@Slf4j
@Component
public class CustomStateMachinePseudoAction implements Action<CustomState, CustomEvent> {
  @Override
  public void execute(StateContext<CustomState, CustomEvent> context) {
    Optional<State<CustomState, CustomEvent>> sourceStateOptional =
        Optional.ofNullable(context).map(StateContext::getSource);
    Optional<State<CustomState, CustomEvent>> targetStateOptional =
        Optional.ofNullable(context).map(StateContext::getTarget);
    log.info(
        "状态机行动(伪态)[现态<{}>,次态<{}>]",
        sourceStateOptional.map(State::getIds).orElse(null),
        targetStateOptional.map(State::getIds).orElse(null));
  }
}
