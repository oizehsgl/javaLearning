package org.oizehsgl.spring.statemachine.persist.redis.runtime;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.oizehsgl.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.spring.statemachine.enums.CustomState;
import org.oizehsgl.spring.statemachine.service.CustomStateMachineService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.StateMachineMessageHeaders;
import reactor.core.publisher.Mono;

/**
 * @author oizehsgl
 */
@Slf4j
@SpringBootTest
class CustomRedisPersistingStateMachineInterceptorTest {

  @Resource private CustomStateMachineService customStateMachineService;

  @Test
  void test() {
    StateMachine<CustomState, CustomEvent> stateMachine =
        customStateMachineService.acquireStateMachine("1024");
    //stateMachine.startReactively().subscribe();

    send(stateMachine, CustomEvent.RESTART);
    send(stateMachine, CustomEvent.E1);
    send(stateMachine, CustomEvent.E2);
    send(stateMachine, CustomEvent.E3);
    send(stateMachine, CustomEvent.E4);
    send(stateMachine, CustomEvent.E5);
    // stateMachine.stopReactively().subscribe();
  }

  private void send(StateMachine<CustomState, CustomEvent> stateMachine, CustomEvent customEvent) {
    log.info("-----------------------------------------------------------------------------------");
    log.info("当前状态{},开始发送{}", stateMachine.getState().getId(), customEvent);
    stateMachine
        .sendEvent(
            Mono.just(
                MessageBuilder.withPayload(customEvent)
                    .setHeader(StateMachineMessageHeaders.HEADER_DO_ACTION_TIMEOUT, 5000)
                    .build()))
        .subscribe();
    log.info("当前状态{},结束发送{}", stateMachine.getState().getId(), customEvent);
    log.info("-----------------------------------------------------------------------------------");
  }
}
