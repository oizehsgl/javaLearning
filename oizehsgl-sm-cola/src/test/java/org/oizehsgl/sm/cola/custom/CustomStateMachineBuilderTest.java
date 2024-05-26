package org.oizehsgl.sm.cola.custom;

import static org.junit.jupiter.api.Assertions.*;

import com.alibaba.cola.statemachine.StateMachine;
import com.alibaba.cola.statemachine.StateMachineFactory;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.sm.cola.context.CustomContext;
import org.oizehsgl.sm.cola.event.CustomEvent;
import org.oizehsgl.sm.cola.state.CustomState;
import org.oizehsgl.sm.cola.statemachine.CustomStateMachine;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@SpringBootTest
class CustomStateMachineBuilderTest {
  @Resource private CustomStateMachineBuilder customStateMachineBuilder;

  @Test
  public void build() {
    StateMachine<CustomState, CustomEvent, CustomContext> stateMachine =
        customStateMachineBuilder.build(CustomStateMachine.TEST.name());
    stateMachine.showStateMachine();
    System.out.println(stateMachine.generatePlantUML());
    CustomState customState1 =
        stateMachine.fireEvent(
            CustomState.S1, CustomEvent.E2, CustomContext.builder().message("1").build());
    stateMachine.showStateMachine();
    System.out.println(customState1);
    StateMachine<CustomState, CustomEvent, CustomContext> stateMachine2 =
        StateMachineFactory.get(CustomStateMachine.TEST.name());
    CustomState customState2 =
        stateMachine2.fireEvent(
            CustomState.S2, CustomEvent.E4, CustomContext.builder().message("1").build());
    System.out.println(customState2);
  }
}
