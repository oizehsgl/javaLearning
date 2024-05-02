package org.oizehsgl.javaLearning.framework.springBoot.statemachine.config;

import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderState;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.persist.StateMachinePersister;

/**
 * 订单状态机持久化
 *
 * @author yueyuanzhi
 */
public class OrderStateMachinePersist implements StateMachinePersister<OrderState, OrderEvent> {
    @Override
    public void persist(StateMachine stateMachine, Object o) throws Exception {

    }

    @Override
    public StateMachine<OrderState, OrderEvent> restore(StateMachine stateMachine, Object o) throws Exception {
        return null;
    }
}
