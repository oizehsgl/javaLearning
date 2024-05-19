package org.oizehsgl.javaLearning.framework.springBoot.statemachine.persist;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.config.DemoStateMachineFactoryConfig;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.persist.map.MapDemoStateMachinePersist;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.persist.redis.RedisDemoStateMachinePersister;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;
import reactor.core.publisher.Mono;

/**
 * @author oizehsgl
 */
@SpringBootTest
class MapDemoStateMachinePersistTest {
  @Resource
  @Qualifier(DemoStateMachineFactoryConfig.LABEL)
  private StateMachineFactory<DemoState, DemoEvent> stateMachineFactory;

  // @Resource
  // private MapDemoStateMachinePersister demoStateMachinePersister;
  @Resource private RedisDemoStateMachinePersister demoStateMachinePersister;
  @Resource private MapDemoStateMachinePersist demoStateMachinePersist;

  @Test
  void writeAndRead() throws Exception {
    StateMachine<DemoState, DemoEvent> stateMachine = stateMachineFactory.getStateMachine();
    stateMachine.start();

    // demoStateMachinePersister.restore(stateMachine,"1");
    System.out.println(stateMachine.getState().getId());
    stateMachine.sendEvent(Mono.just(MessageBuilder.withPayload(DemoEvent.E1).build())).subscribe();
    demoStateMachinePersister.persist(stateMachine, "1");
    System.out.println(demoStateMachinePersist.getContexts());

    demoStateMachinePersister.restore(stateMachine, "1");
    System.out.println(stateMachine.getState().getId());
    stateMachine.sendEvent(DemoEvent.E2);
    demoStateMachinePersister.persist(stateMachine, "1");
    System.out.println(demoStateMachinePersist.getContexts());

    // demoStateMachinePersister.restore(stateMachine,"1");
    System.out.println(stateMachine.getState().getId());
    stateMachine.sendEvent(DemoEvent.E3);
    demoStateMachinePersister.persist(stateMachine, "1");
    System.out.println(demoStateMachinePersist.getContexts());

    demoStateMachinePersister.restore(stateMachine, "1");
    System.out.println(stateMachine.getState().getId());
    stateMachine.sendEvent(
        MessageBuilder.withPayload(DemoEvent.E4)
            .setHeader(Object.class.getSimpleName(), new Object())
            .build());
    demoStateMachinePersister.persist(stateMachine, "1");

    demoStateMachinePersister.restore(stateMachine, "1");
    System.out.println(stateMachine.getState().getId());
    stateMachine.stop();
    demoStateMachinePersister.persist(stateMachine, "1");
  }
}
