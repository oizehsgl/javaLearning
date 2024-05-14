package org.oizehsgl.javaLearning.framework.springBoot.statemachine.persist;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.config.DemoStateMachineFactoryConfig;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

/**
 * @author yueyuanzhi
 */
@SpringBootTest
class InMemoryDemoStateMachinePersistTest {
    @Resource
    @Qualifier(DemoStateMachineFactoryConfig.LABEL)
    private StateMachineFactory<DemoState, DemoEvent> stateMachineFactory;

    @Test
    void writeAndRead() {
        StateMachine<DemoState, DemoEvent> stateMachine = stateMachineFactory.getStateMachine();
        stateMachine.start();
        System.out.println(stateMachine.getState().getId());
        stateMachine.sendEvent(DemoEvent.E1);
        System.out.println(stateMachine.getState().getId());
        stateMachine.sendEvent(DemoEvent.E2);
        System.out.println(stateMachine.getState().getId());
        stateMachine.sendEvent(DemoEvent.E3);
        System.out.println(stateMachine.getState().getId());
        stateMachine.sendEvent(MessageBuilder
                .withPayload(DemoEvent.E4)
                .setHeader(Object.class.getSimpleName(), new Object())
                .build());
        System.out.println(stateMachine.getState().getId());
        stateMachine.stop();
        System.out.println(stateMachine.getState().getId());
    }
}