package org.oizehsgl.javaLearning.framework.springBoot.statemachine.hook;

import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
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
public class DemoStateMachineAction implements Action<DemoState, DemoEvent> {
    @Override
    public void execute(StateContext<DemoState, DemoEvent> context) {
        log.info("状态机动作执行[source<{}>,target<{}>]", context.getSource().getId(),
                context.getTarget().getId());
    }
}
