package org.oizehsgl.sm.spring.statemachine.hook.listener;

import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * 状态机监听者
 *
 * @author oizehsgl
 */
@Slf4j
@Component
public class CustomStateMachineListener
    extends StateMachineListenerAdapter<CustomState, CustomEvent> {
  @Override
  public void stateChanged(
      State<CustomState, CustomEvent> from, State<CustomState, CustomEvent> to) {
    Optional<State<CustomState, CustomEvent>> fromOptional = Optional.ofNullable(from);
    Optional<State<CustomState, CustomEvent>> toOptional = Optional.ofNullable(to);
    CustomState fromState = fromOptional.map(State::getId).orElse(null);
    CustomState toState = toOptional.map(State::getId).orElse(null);

      try {
          TimeUnit.MILLISECONDS.sleep(100);
      } catch (InterruptedException e) {
          throw new RuntimeException(e);
      }
      log.info(
        "状态机监听(变更)[现态<{}>,次态<{}>]",
        Optional.ofNullable(from).map(State::getIds).orElse(null),
        Optional.ofNullable(to).map(State::getIds).orElse(null));
  }

  @Override
  public void extendedStateChanged(Object key, Object value) {
    log.info("状态机监听(扩展)[key<{}>,value<{}>]", key, value);
  }
}
