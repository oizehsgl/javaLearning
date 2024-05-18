package org.oizehsgl.javaLearning.framework.springBoot.statemachine.service;

import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.config.StateMachineFactory;
import org.springframework.statemachine.service.DefaultStateMachineService;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class DemoStateMachineService extends DefaultStateMachineService<DemoState, DemoEvent> {
    public DemoStateMachineService(StateMachineFactory<DemoState, DemoEvent> stateMachineFactory, @Qualifier("redisDemoStateMachineRuntimePersister") StateMachinePersist<DemoState, DemoEvent, String> stateMachinePersist) {
        super(stateMachineFactory, stateMachinePersist);
    }
}
