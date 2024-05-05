package org.oizehsgl.javaLearning.framework.springBoot.statemachine.hook;

import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 订单状态机监听者
 *
 * @author yueyuanzhi
 */
@Slf4j
@Component
public class DemoStateMachineListener extends StateMachineListenerAdapter<DemoState, DemoEvent> {
    @Override
    public void stateChanged(State<DemoState, DemoEvent> from, State<DemoState, DemoEvent> to) {
        log.info("状态机监听(状态变更)[from<{}>,to<{}>]", Optional.ofNullable(from).map(State::getId).orElse(null),
                Optional.ofNullable(to).map(State::getId).orElse(null));
    }
}
