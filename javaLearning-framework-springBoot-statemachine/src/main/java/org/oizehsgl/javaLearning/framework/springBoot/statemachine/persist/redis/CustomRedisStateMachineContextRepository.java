package org.oizehsgl.javaLearning.framework.springBoot.statemachine.persist.redis;

import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
import org.oizehsgl.nosql.redis.wrapper.serializer.CustomStringRedisSerializer;
import org.oizehsgl.nosql.redis.wrapper.template.CustomRedisTemplate;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.statemachine.data.redis.RedisStateMachineContextRepository;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class CustomRedisStateMachineContextRepository
    extends RedisStateMachineContextRepositoryAdapter<DemoState, DemoEvent> {
    /**
     * Instantiates a new redis state machine context repository.
     *
     * @param redisTemplate the redis connection factory
     */
    public CustomRedisStateMachineContextRepository(RedisConnectionFactory connectionFactory, CustomStringRedisSerializer customStringRedisSerializer) {
        super(connectionFactory,customStringRedisSerializer);
    }
}
