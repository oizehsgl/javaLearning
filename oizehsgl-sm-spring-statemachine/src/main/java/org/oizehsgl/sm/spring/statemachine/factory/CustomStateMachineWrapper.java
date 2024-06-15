package org.oizehsgl.sm.spring.statemachine.factory;

import java.util.Optional;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.oizehsgl.sm.spring.statemachine.persist.redis.CustomRedisStateMachinePersister;
import org.springframework.lang.NonNull;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.StateMachineMessageHeaders;
import org.springframework.statemachine.state.State;
import reactor.core.publisher.Mono;

/**
 * @author oizehsgl
 */
@Slf4j
@Builder
public class CustomStateMachineWrapper extends StateMachineAdapter<CustomState, CustomEvent> {
  @Getter
  @NonNull private final StateMachine<CustomState, CustomEvent> stateMachine;

  @NonNull private CustomRedisStateMachinePersister customRedisStateMachinePersister;

  @Override
  public synchronized boolean sendEvent(CustomEvent customEvent) {
    try {
      restore();
      log.info("---------------------------------------------------------------------------------");
      log.info(
          "当前状态{},开始发送{}",
          Optional.of(stateMachine).map(StateMachine::getState).map(State::getIds).orElse(null),
          customEvent);
      stateMachine
          .sendEvent(
              Mono.just(
                  MessageBuilder.withPayload(customEvent)
                      .setHeader(StateMachineMessageHeaders.HEADER_DO_ACTION_TIMEOUT, 5000)
                      .build()))
          .blockLast();
      log.info(
          "当前状态{},结束发送{}",
          Optional.of(stateMachine).map(StateMachine::getState).map(State::getIds).orElse(null),
          customEvent);
      log.info("---------------------------------------------------------------------------------");
      /// 使用监听器执行持久化
      //persist();
    } catch (Exception e) {
      log.error("发送事件异常[状态机标识<{}>]", stateMachine.getId(), e);
      return false;
    }
    return true;
  }

  public synchronized void persist() {
    try {
      customRedisStateMachinePersister.persist(stateMachine, stateMachine.getId());
    } catch (Exception e) {
      log.error("持久化存储异常[状态机标识<{}>]", stateMachine.getId(), e);
    }
  }

  public synchronized StateMachine<CustomState, CustomEvent> restore() {
    try {
      return customRedisStateMachinePersister.restore(stateMachine, stateMachine.getId());
    } catch (Exception e) {
      log.error("持久化恢复异常[状态机标识<{}>]", stateMachine.getId(), e);
      return null;
    }
  }

  public synchronized void start() {
    stateMachine.startReactively().block();
  }
}
