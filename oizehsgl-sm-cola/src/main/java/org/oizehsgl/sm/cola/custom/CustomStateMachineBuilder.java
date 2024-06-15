package org.oizehsgl.sm.cola.custom;

import com.alibaba.cola.statemachine.builder.StateMachineBuilderImpl;
import org.oizehsgl.sm.cola.action.CustomAction;
import org.oizehsgl.sm.cola.condition.CustomCondition;
import org.oizehsgl.sm.cola.context.CustomContext;
import org.oizehsgl.sm.cola.event.CustomEvent;
import org.oizehsgl.sm.cola.state.CustomState;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class CustomStateMachineBuilder
    extends StateMachineBuilderImpl<CustomState, CustomEvent, CustomContext> {
  public CustomStateMachineBuilder(CustomCondition customCondition, CustomAction customAction) {
    super();
    StateMachineBuilderImpl<CustomState, CustomEvent, CustomContext> builder = this;
    // 定义状态转换事件、条件和动作
    builder
        .externalTransition()
        .from(CustomState.S1)
        .to(CustomState.S2)
        .on(CustomEvent.E2)
        .when(customCondition)
        .perform(customAction);
    // builder
    //    .externalTransition()
    //    .from(CustomState.S2)
    //    .to(CustomState.S3)
    //    .on(CustomEvent.E3)
    //    .when(customCondition)
    //    .perform(customAction);
    builder
        .externalTransitions()
        .fromAmong(CustomState.S1, CustomState.S2, CustomState.S3)
        .to(CustomState.S4)
        .on(CustomEvent.E4)
        .perform(customAction);
    builder
        .externalTransition()
        .from(CustomState.S4)
        .to(CustomState.S1)
        .on(CustomEvent.E1)
        .perform(customAction);
    builder.internalTransition().within(CustomState.S2).on(CustomEvent.E3).perform(customAction);
  }
}
