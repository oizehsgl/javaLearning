package org.oizehsgl.javaLearning.framework.springBoot.statemachine.hook;

import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.guard.Guard;
import org.springframework.stereotype.Component;

/**
 * 订单状态机保护
 *
 * @author yueyuanzhi
 */
@Component
public class DemoStateMachineGuard implements Guard<DemoState, DemoEvent> {
    @Override
    public boolean evaluate(StateContext<DemoState, DemoEvent> context) {
        return true;
    }
}
