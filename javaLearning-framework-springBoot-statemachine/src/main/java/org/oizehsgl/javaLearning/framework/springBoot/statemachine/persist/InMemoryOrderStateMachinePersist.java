package org.oizehsgl.javaLearning.framework.springBoot.statemachine.persist;

import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.OrderState;
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
public class InMemoryOrderStateMachinePersist implements StateMachinePersist<OrderState, OrderEvent, String> {
    private final Map<String, StateMachineContext<OrderState, OrderEvent>> contexts = new ConcurrentHashMap<>();

    @Override
    public void write(StateMachineContext<OrderState, OrderEvent> context, String contextObj) throws Exception {
        contexts.put(contextObj, context);
    }

    @Override
    public StateMachineContext<OrderState, OrderEvent> read(String contextObj) throws Exception {
        return contexts.get(contextObj);
    }
}
