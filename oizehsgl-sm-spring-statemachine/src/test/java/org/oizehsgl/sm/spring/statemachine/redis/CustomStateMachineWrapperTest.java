package org.oizehsgl.sm.spring.statemachine.redis;

import jakarta.annotation.Resource;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.factory.CustomStateMachineWrapper;
import org.oizehsgl.sm.spring.statemachine.service.CustomStateMachineWrapperService;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@Slf4j
@SpringBootTest
class CustomStateMachineWrapperTest {

  @Resource private CustomStateMachineWrapperService customStateMachineWrapperService;

  @Test
  void test() throws Exception {
    String key = "2222";
    CustomStateMachineWrapper customStateMachineWrapper =
        customStateMachineWrapperService.acquireStateMachineWrapper(key);
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
    TimeUnit.SECONDS.sleep(30);
  }
}
