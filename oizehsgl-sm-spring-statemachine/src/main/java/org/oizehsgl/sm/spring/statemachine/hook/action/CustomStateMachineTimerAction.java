package org.oizehsgl.sm.spring.statemachine.hook.action;

import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachineMessageHeaders;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.state.State;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * 状态机行动
 *
 * @author oizehsgl
 */
@Slf4j
@Component
public class CustomStateMachineTimerAction implements Action<CustomState, CustomEvent> {
  @Override
  public void execute(StateContext<CustomState, CustomEvent> context) {
    Optional<State<CustomState, CustomEvent>> sourceStateOptional =
        Optional.ofNullable(context).map(StateContext::getSource);
    Optional<State<CustomState, CustomEvent>> targetStateOptional =
        Optional.ofNullable(context).map(StateContext::getTarget);
    log.info(
        "状态机行动(时间)[现态<{}>,次态<{}>]",
        sourceStateOptional.map(State::getIds).orElse(null),
        targetStateOptional.map(State::getIds).orElse(null));
  }
}
