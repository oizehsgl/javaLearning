package org.oizehsgl.javaLearning.framework.springBoot.statemachine.persist.redis.runtime;

import jakarta.annotation.Resource;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.persist.redis.CustomRedisStateMachineContextRepository;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.persist.redis.RedisRepositoryDemoStateMachinePersist;
import org.oizehsgl.nosql.redis.wrapper.properties.CustomRedisProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.data.redis.RedisPersistingStateMachineInterceptor;
import org.springframework.statemachine.data.redis.RedisRepositoryStateMachine;
import org.springframework.statemachine.data.redis.RedisRepositoryStateMachinePersist;
import org.springframework.statemachine.data.redis.RedisStateMachineRepository;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class RedisDemoStateMachineRuntimePersister
    extends RedisPersistingStateMachineInterceptor<DemoState, DemoEvent, String> {
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

