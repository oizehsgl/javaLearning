package org.oizehsgl.sm.spring.statemachine.redis.runtime;

import jakarta.annotation.Resource;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.oizehsgl.sm.spring.statemachine.service.CustomStateMachineService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.StateMachineMessageHeaders;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @author oizehsgl
 */
@Slf4j
@SpringBootTest
class CustomRedisPersistingStateMachineInterceptorTest {

  @Resource private CustomStateMachineService customStateMachineService;

  @SneakyThrows
  @Test
  void test() {
    customStateMachineService.clear("1024");
    StateMachine<CustomState, CustomEvent> stateMachine =
        customStateMachineService.acquireStateMachine("1024",false);
    stateMachine.startReactively().subscribe();
    //log.info("当前状态{}-----", stateMachine.getState().getIds());
    send(stateMachine, CustomEvent.NEXT);
    send(stateMachine, CustomEvent.NEXT);
    send(stateMachine, CustomEvent.NEXT);
    send(stateMachine, CustomEvent.ENTRY);
    send(stateMachine, CustomEvent.EXIT);
    send(stateMachine, CustomEvent.NEXT);
    //send(stateMachine, CustomEvent.LAST);
    //send(stateMachine, CustomEvent.NEXT);
    //send(stateMachine, CustomEvent.SUB_NEXT1);
    //send(stateMachine, CustomEvent.SUB_NEXT1);

    //send(stateMachine, CustomEvent.SUB_NEXT2);
    //send(stateMachine, CustomEvent.SUB_NEXT3);
    //send(stateMachine, CustomEvent.SUB_NEXT1);
    //send(stateMachine, CustomEvent.NEXT);
    // send(stateMachine, CustomEvent.SUB_NEXT2);
    // stateMachine.stopReactively().subscribe();

    TimeUnit.SECONDS.sleep(3);
    System.out.println(stateMachine.getState().getIds());
  }

  private void send(StateMachine<CustomState, CustomEvent> stateMachine, CustomEvent customEvent) {
    log.info("-----------------------------------------------------------------------------------");
    log.info("当前状态{},开始发送{}", stateMachine.getState().getIds(), customEvent);
    stateMachine
        .sendEvent(
            Mono.just(
                MessageBuilder.withPayload(customEvent)
                    .setHeader(StateMachineMessageHeaders.HEADER_DO_ACTION_TIMEOUT, 5000)
                    .build()))
        .subscribe();
    log.info("当前状态{},结束发送{}", stateMachine.getState().getIds(), customEvent);
    log.info("-----------------------------------------------------------------------------------");
  }
}
