package org.oizehsgl.javaLearning.framework.springBoot.statemachine.trigger;

import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderState;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.stereotype.Component;

/**
 * 订单状态机动作
 *
 * @author yueyuanzhi
 */
@Slf4j
@Component
public class OrderStateMachineAction implements Action<OrderState, OrderEvent> {
    @Override
    public void execute(StateContext<OrderState, OrderEvent> context) {
        log.info("状态机动作执行[source<{}>,target<{}>]", context.getSource().getId(),
                context.getTarget().getId());
    }
}
