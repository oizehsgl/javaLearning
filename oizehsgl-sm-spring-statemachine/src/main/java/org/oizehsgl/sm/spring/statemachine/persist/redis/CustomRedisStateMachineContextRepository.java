package org.oizehsgl.sm.spring.statemachine.persist.redis;

import org.oizehsgl.nosql.redis.wrapper.serializer.CustomStringRedisSerializer;
import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class CustomRedisStateMachineContextRepository
    extends RedisStateMachineContextRepositoryAdapter<CustomState, CustomEvent> {
  public static final String BEAN_NAME = "customRedisStateMachineContextRepository";

  /**
   * Instantiates a new redis state machine context repository.
   *
   * @param redisConnectionFactory the redis connection factory
   * @param customStringRedisSerializer 自定义序列化器
   */
  public CustomRedisStateMachineContextRepository(
      RedisConnectionFactory redisConnectionFactory,
      CustomStringRedisSerializer customStringRedisSerializer) {
    super(redisConnectionFactory, customStringRedisSerializer);
  }
}
