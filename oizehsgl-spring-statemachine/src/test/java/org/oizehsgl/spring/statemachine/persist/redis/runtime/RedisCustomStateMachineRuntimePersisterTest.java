package org.oizehsgl.spring.statemachine.persist.redis.runtime;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.spring.statemachine.config.CustomStateMachineFactoryConfig;
import org.oizehsgl.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.spring.statemachine.enums.CustomState;
import org.oizehsgl.spring.statemachine.service.CustomStateMachineService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import reactor.core.publisher.Mono;

/**
 * @author oizehsgl
 */
@SpringBootTest
class RedisCustomStateMachineRuntimePersisterTest {

  @Resource(name = CustomStateMachineFactoryConfig.FACTORY_NAME)
  private StateMachineFactory<CustomState, CustomEvent> stateMachineFactory;
  @Resource
  private CustomStateMachineService customStateMachineService;

  @Test
  void writeAndRead() {
    //StateMachine<CustomState, CustomEvent> stateMachine = stateMachineFactory.getStateMachine("1350");
    StateMachine<CustomState, CustomEvent> stateMachine = customStateMachineService.acquireStateMachine("1024");
    stateMachine.start();

    System.out.println(stateMachine.getState().getId());
    stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload(CustomEvent.E1).build())).subscribe();

    System.out.println(stateMachine.getState().getId());
    stateMachine.sendEvent(CustomEvent.E2);

    System.out.println(stateMachine.getState().getId());
    stateMachine.sendEvent(CustomEvent.E3);
    stateMachine.sendEvent(CustomEvent.E1);

    System.out.println(stateMachine.getState().getId());
    stateMachine.sendEvent(
        MessageBuilder.withPayload(CustomEvent.E4)
            .setHeader(Object.class.getSimpleName(), new Object())
            .build());

    System.out.println(stateMachine.getState().getId());
  }
}
