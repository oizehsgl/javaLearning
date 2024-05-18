package org.oizehsgl.javaLearning.framework.springBoot.statemachine.hook;

import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.state.State;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 订单状态机动作
 *
 * @author oizehsgl
 */
@Slf4j
@Component
public class DemoStateMachineAction implements Action<DemoState, DemoEvent> {
    @Override
    public void execute(StateContext<DemoState, DemoEvent> context) {
        Optional<State<DemoState, DemoEvent>> sourceStateOptional = Optional.ofNullable(context).map(StateContext::getSource);
        Optional<State<DemoState, DemoEvent>> targetStateOptional = Optional.ofNullable(context).map(StateContext::getTarget);
        log.info("状态机动作触发[source<{}>,target<{}>]",
                sourceStateOptional.map(State::getId).orElse(null), targetStateOptional.map(State::getId).orElse(null));
        if(context.getEvent() == DemoEvent.E3){
            //throw new RuntimeException("状态机执行异常");
        }
    }
}
