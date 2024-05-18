package org.oizehsgl.javaLearning.framework.springBoot.statemachine.persist.map;

import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.persist.AbstractStateMachinePersister;
import org.springframework.stereotype.Component;

/**
 * Map-状态机持久化实现
 *
 * @author oizehsgl
 */
@Component
public class MapDemoStateMachinePersister extends AbstractStateMachinePersister<DemoState, DemoEvent,String> {
    /**
     * Instantiates a new abstract state machine persister.
     *
     * @param stateMachinePersist the state machine persist
     */
    public MapDemoStateMachinePersister(@Qualifier(MapDemoStateMachinePersist.BEAN_NAME) StateMachinePersist<DemoState, DemoEvent,String> stateMachinePersist) {
        super(stateMachinePersist);
    }
}
