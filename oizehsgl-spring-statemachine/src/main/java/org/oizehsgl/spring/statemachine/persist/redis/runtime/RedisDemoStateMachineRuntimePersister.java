package org.oizehsgl.spring.statemachine.persist.redis.runtime;

import org.oizehsgl.spring.statemachine.enums.DemoEvent;
import org.oizehsgl.spring.statemachine.enums.DemoState;
import org.springframework.statemachine.data.redis.RedisPersistingStateMachineInterceptor;
import org.springframework.statemachine.data.redis.RedisStateMachineRepository;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class RedisDemoStateMachineRuntimePersister
    extends RedisPersistingStateMachineInterceptor<DemoState, DemoEvent, String> {
  public static final String BEAN_NAME = "redisDemoStateMachineRuntimePersister";
  //@Resource
  //private CustomRedisProperties customRedisProperties;

  public RedisDemoStateMachineRuntimePersister(RedisStateMachineRepository redisStateMachineRepository) {
    super(redisStateMachineRepository);
  }
  //
  //@Override
  //public StateMachineContext<DemoState, DemoEvent> read(String contextObj) throws Exception {
  //  contextObj = contextObj.substring(customRedisProperties.getPrefix().length());
  //  return super.read(contextObj);
  //}
  //
  //@Override
  //public void write(StateMachineContext<DemoState, DemoEvent> context, String contextObj) throws Exception {
  //  contextObj = customRedisProperties.getPrefix() + contextObj;
  //  super.write(context, contextObj);
  //}
}

