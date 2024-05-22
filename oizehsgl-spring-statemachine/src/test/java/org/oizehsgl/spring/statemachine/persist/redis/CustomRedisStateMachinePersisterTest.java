package org.oizehsgl.spring.statemachine.persist.redis;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.spring.statemachine.enums.CustomState;
import org.oizehsgl.spring.statemachine.factory.CustomStateMachineFactoryConfig;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import reactor.core.publisher.Mono;

/**
 * @author oizehsgl
 */
@SpringBootTest
class CustomRedisStateMachinePersisterTest {

  @Resource private CustomRedisStateMachinePersister customRedisStateMachinePersister;

  @Resource(name = CustomStateMachineFactoryConfig.FACTORY_NAME)
  private StateMachineFactory<CustomState, CustomEvent> stateMachineFactory;

  @Test
  void test() throws Exception {
    StateMachine<CustomState, CustomEvent> stateMachine = stateMachineFactory.getStateMachine("MMMM");
    stateMachine.start();

    String key="WWW";
    //customRedisStateMachinePersister.restore(stateMachine,key);
    System.out.println(stateMachine.getState().getId());
    stateMachine
        .sendEvent(Mono.just(MessageBuilder.withPayload(CustomEvent.E1).build()))
        .subscribe();
    customRedisStateMachinePersister.persist(stateMachine,key);

    customRedisStateMachinePersister.restore(stateMachine,key);
    System.out.println(stateMachine.getState().getId());
    stateMachine.sendEvent(CustomEvent.E2);
    customRedisStateMachinePersister.persist(stateMachine,key);

    customRedisStateMachinePersister.restore(stateMachine,key);
    System.out.println(stateMachine.getState().getId());
    stateMachine.sendEvent(CustomEvent.E3);
    stateMachine.sendEvent(CustomEvent.E1);
    customRedisStateMachinePersister.persist(stateMachine,key);

    customRedisStateMachinePersister.restore(stateMachine,key);
    System.out.println(stateMachine.getState().getId());
    stateMachine.sendEvent(
        MessageBuilder.withPayload(CustomEvent.E4)
            .setHeader(Object.class.getSimpleName(), new Object())
            .build());
    customRedisStateMachinePersister.persist(stateMachine,key);

    System.out.println(stateMachine.getState().getId());
  }
}
