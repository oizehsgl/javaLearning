package org.oizehsgl.sm.spring.statemachine.service;

import static org.junit.jupiter.api.Assertions.*;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.factory.CustomStateMachineWrapper;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@SpringBootTest
class CustomStateMachineWrapperServiceTest {
  @Resource private CustomStateMachineWrapperService customStateMachineWrapperService;

  @Test
  public void test() {
    String id = "1111";
    CustomStateMachineWrapper customStateMachineWrapper =
        customStateMachineWrapperService.acquireStateMachineWrapper(id);
    customStateMachineWrapper.sendEvent(CustomEvent.NEXT);
    customStateMachineWrapper.sendEvent(CustomEvent.NEXT);
    customStateMachineWrapper.sendEvent(CustomEvent.NEXT);
    customStateMachineWrapper.sendEvent(CustomEvent.ENTRY);
    customStateMachineWrapper.sendEvent(CustomEvent.EXIT);
    customStateMachineWrapper.sendEvent(CustomEvent.NEXT);
    customStateMachineWrapper.sendEvent(CustomEvent.LAST);
    customStateMachineWrapper.sendEvent(CustomEvent.NEXT);
    customStateMachineWrapper.sendEvent(CustomEvent.SUB_NEXT1);
    customStateMachineWrapper.sendEvent(CustomEvent.SUB_NEXT1);
    customStateMachineWrapper.sendEvent(CustomEvent.SUB_NEXT2);
    customStateMachineWrapper.sendEvent(CustomEvent.SUB_NEXT2);
    customStateMachineWrapper.sendEvent(CustomEvent.CHOICE);
  }
}
