package org.oizehsgl.sm.spring.statemachine;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.oizehsgl.sm.spring.statemachine.factory.CustomStateMachineFactoryConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineFactory;

/**
 * @author oizehsgl
 */
@SpringBootTest
public class WithLocalTest {
  @Resource(name = CustomStateMachineFactoryConfig.BEAN_NAME)
  private StateMachineFactory<CustomState, CustomEvent> stateMachineFactory;
  @Test
  public void test() {
    StateMachine<CustomState, CustomEvent> stateMachine = stateMachineFactory.getStateMachine("local");
    stateMachine.start();
    System.out.println();
    stateMachine.sendEvent(CustomEvent.LOCAL);
    System.out.println();
    stateMachine.sendEvent(CustomEvent.LOCAL);
    System.out.println();
    stateMachine.sendEvent(CustomEvent.LOCAL);
    System.out.println();
    stateMachine.sendEvent(CustomEvent.LOCAL);
  }
}
