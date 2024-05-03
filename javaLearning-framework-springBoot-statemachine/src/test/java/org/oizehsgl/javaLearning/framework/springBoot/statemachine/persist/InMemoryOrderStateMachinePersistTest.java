package org.oizehsgl.javaLearning.framework.springBoot.statemachine.persist;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.config.OrderStateMachineFactoryConfig;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderState;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

/**
 * @author yueyuanzhi
 */
@SpringBootTest
class InMemoryOrderStateMachinePersistTest {
    @Resource
    @Qualifier(OrderStateMachineFactoryConfig.STATE_MACHINE_FACTORY)
    private StateMachineFactory<OrderState, OrderEvent> stateMachineFactory;

    @Test
    void writeAndRead() {
        StateMachine<OrderState, OrderEvent> stateMachine = stateMachineFactory.getStateMachine();
        stateMachine.start();
        System.out.println(stateMachine.getState().getId());
        stateMachine.sendEvent(OrderEvent.PAYED);
        System.out.println(stateMachine.getState().getId());
        stateMachine.sendEvent(OrderEvent.DELIVERY);
        System.out.println(stateMachine.getState().getId());
        stateMachine.stop();
        System.out.println(stateMachine.getState().getId());
    }
}