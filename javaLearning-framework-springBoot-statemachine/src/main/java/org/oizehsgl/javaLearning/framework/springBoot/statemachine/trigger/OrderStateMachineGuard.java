package org.oizehsgl.javaLearning.framework.springBoot.statemachine.trigger;

import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderState;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.guard.Guard;
import org.springframework.stereotype.Component;

/**
 * 订单状态机保护
 *
 * @author yueyuanzhi
 */
@Component
public class OrderStateMachineGuard implements Guard<OrderState, OrderEvent> {
    @Override
    public boolean evaluate(StateContext<OrderState, OrderEvent> context) {
        return true;
    }
}
