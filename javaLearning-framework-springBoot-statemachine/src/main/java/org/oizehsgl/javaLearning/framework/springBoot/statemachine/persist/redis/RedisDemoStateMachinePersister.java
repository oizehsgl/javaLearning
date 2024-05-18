package org.oizehsgl.javaLearning.framework.springBoot.statemachine.persist.redis;

import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.statemachine.data.redis.RedisStateMachinePersister;
import org.springframework.stereotype.Component;

/**
 * Redis-状态机持久化接口
 * @author oizehsgl
 */
@Component
public class RedisDemoStateMachinePersister extends RedisStateMachinePersister<DemoState, DemoEvent> {
    public RedisDemoStateMachinePersister(@Qualifier(RedisRepositoryDemoStateMachinePersist.BEAN_NAME) StateMachinePersist<DemoState, DemoEvent, String> stateMachinePersist) {
        super(stateMachinePersist);
    }
}
