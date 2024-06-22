package org.oizehsgl.sm.spring.statemachine.hook.action;

import java.util.Optional;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
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
public class CustomStateMachineEntryAction implements Action<CustomState, CustomEvent> {
  @Override
  public void execute(StateContext<CustomState, CustomEvent> context) {
    Optional<State<CustomState, CustomEvent>> sourceStateOptional =
        Optional.ofNullable(context).map(StateContext::getSource);
    Optional<State<CustomState, CustomEvent>> targetStateOptional =
        Optional.ofNullable(context).map(StateContext::getTarget);
    try {
      log.info(
          "状态机行动(进入-睡眠开始)[现态<{}>,次态<{}>]",
          sourceStateOptional.map(State::getIds).orElse(null),
          targetStateOptional.map(State::getIds).orElse(null));
      TimeUnit.MILLISECONDS.sleep(250);
      log.info(
          "状态机行动(进入-睡眠结束)[现态<{}>,次态<{}>]",
          sourceStateOptional.map(State::getIds).orElse(null),
          targetStateOptional.map(State::getIds).orElse(null));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    log.info(
        "状态机行动(进入)[现态<{}>,次态<{}>]",
        sourceStateOptional.map(State::getIds).orElse(null),
        targetStateOptional.map(State::getIds).orElse(null));
  }
}
