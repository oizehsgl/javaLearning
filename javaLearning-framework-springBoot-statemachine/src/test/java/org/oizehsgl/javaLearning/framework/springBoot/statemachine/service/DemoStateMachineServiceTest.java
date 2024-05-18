package org.oizehsgl.javaLearning.framework.springBoot.statemachine.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.statemachine.StateMachine;

/**
 * @author oizehsgl
 */
@SpringBootTest
class DemoStateMachineServiceTest {
    @Resource
    private DemoStateMachineService demoStateMachineService;

    @Test
    public void test() throws Exception {
        String machineId = String.format("%s:%s","test","112");
        StateMachine<DemoState, DemoEvent> stateMachine = demoStateMachineService.acquireStateMachine(machineId,true);
        stateMachine.sendEvent(DemoEvent.E1);
        demoStateMachineService.releaseStateMachine(machineId,true);
        stateMachine = demoStateMachineService.acquireStateMachine(machineId);
        stateMachine.sendEvent(DemoEvent.E2);
        demoStateMachineService.releaseStateMachine(machineId);
    }
}