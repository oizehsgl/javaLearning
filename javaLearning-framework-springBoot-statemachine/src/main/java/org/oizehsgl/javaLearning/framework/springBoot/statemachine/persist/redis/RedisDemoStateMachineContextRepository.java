package org.oizehsgl.javaLearning.framework.springBoot.statemachine.persist.redis;

import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.statemachine.data.redis.RedisStateMachineContextRepository;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class RedisDemoStateMachineContextRepository extends RedisStateMachineContextRepository<DemoState, DemoEvent> {
    public RedisDemoStateMachineContextRepository(RedisConnectionFactory redisConnectionFactory) {
        super(redisConnectionFactory);
    }
}
