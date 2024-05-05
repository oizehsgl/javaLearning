package org.oizehsgl.javaLearning.framework.springBoot.statemachine.persist;

import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 内存状态机持久化
 *
 * @author yueyuanzhi
 */
@Component
public class InMemoryDemoStateMachinePersist implements StateMachinePersist<DemoState, DemoEvent, String> {
    private final Map<String, StateMachineContext<DemoState, DemoEvent>> contexts = new ConcurrentHashMap<>();

    @Override
    public void write(StateMachineContext<DemoState, DemoEvent> context, String contextObj) throws Exception {
        contexts.put(contextObj, context);
    }

    @Override
    public StateMachineContext<DemoState, DemoEvent> read(String contextObj) throws Exception {
        return contexts.get(contextObj);
    }
}
