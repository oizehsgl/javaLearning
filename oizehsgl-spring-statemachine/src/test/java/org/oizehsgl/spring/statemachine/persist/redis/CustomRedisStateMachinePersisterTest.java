package org.oizehsgl.spring.statemachine.persist.redis;


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
    StateMachine<CustomState, CustomEvent> stateMachine =
        stateMachineFactory.getStateMachine("MMMM");
    stateMachine.startReactively().subscribe();

    String key = "WWW";
    // customRedisStateMachinePersister.restore(stateMachine,key);
    System.out.println(stateMachine.getState().getId());
    stateMachine
        .sendEvent(Mono.just(MessageBuilder.withPayload(CustomEvent.E1).build()))
        .subscribe();
    customRedisStateMachinePersister.persist(stateMachine, key);

    customRedisStateMachinePersister.restore(stateMachine, key);
    System.out.println(stateMachine.getState().getId());
    stateMachine
        .sendEvent(Mono.just(MessageBuilder.withPayload(CustomEvent.E2).build()))
        .subscribe();
    customRedisStateMachinePersister.persist(stateMachine, key);

    customRedisStateMachinePersister.restore(stateMachine, key);
    System.out.println(stateMachine.getState().getId());
    stateMachine
        .sendEvent(Mono.just(MessageBuilder.withPayload(CustomEvent.E3).build()))
        .subscribe();
    customRedisStateMachinePersister.persist(stateMachine, key);

    customRedisStateMachinePersister.restore(stateMachine, key);
    System.out.println(stateMachine.getState().getId());
    stateMachine
        .sendEvent(
            Mono.just(
                MessageBuilder.withPayload(CustomEvent.E4)
                    .setHeader(Object.class.getSimpleName(), new Object())
                    .build()))
        .subscribe();
    customRedisStateMachinePersister.persist(stateMachine, key);

    System.out.println(stateMachine.getState().getId());
  }
}
