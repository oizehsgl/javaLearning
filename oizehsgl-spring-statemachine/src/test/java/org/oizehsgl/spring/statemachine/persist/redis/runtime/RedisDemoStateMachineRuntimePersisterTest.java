package org.oizehsgl.spring.statemachine.persist.redis.runtime;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.spring.statemachine.config.DemoStateMachineFactoryConfig;
import org.oizehsgl.spring.statemachine.enums.DemoEvent;
import org.oizehsgl.spring.statemachine.enums.DemoState;
import org.oizehsgl.spring.statemachine.service.DemoStateMachineService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * @author oizehsgl
 */
@SpringBootTest
class RedisDemoStateMachineRuntimePersisterTest {

  @Resource(name = DemoStateMachineFactoryConfig.LABEL)
  private StateMachineFactory<DemoState, DemoEvent> stateMachineFactory;
  @Resource
  private DemoStateMachineService demoStateMachineService;

  @Test
  void writeAndRead() {
    //StateMachine<DemoState, DemoEvent> stateMachine = stateMachineFactory.getStateMachine("1350");
    StateMachine<DemoState, DemoEvent> stateMachine = demoStateMachineService.acquireStateMachine("1350");
    stateMachine.start();

    System.out.println(stateMachine.getState().getId());
    stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload(DemoEvent.E1).build())).subscribe();

    System.out.println(stateMachine.getState().getId());
    stateMachine.sendEvent(DemoEvent.E2);

    System.out.println(stateMachine.getState().getId());
    stateMachine.sendEvent(DemoEvent.E3);
    stateMachine.sendEvent(DemoEvent.E1);

    System.out.println(stateMachine.getState().getId());
    stateMachine.sendEvent(
        MessageBuilder.withPayload(DemoEvent.E4)
            .setHeader(Object.class.getSimpleName(), new Object())
            .build());

    System.out.println(stateMachine.getState().getId());
  }
}
