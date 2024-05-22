//package org.oizehsgl.spring.statemachine.persist.redis;
//
//import org.oizehsgl.spring.statemachine.enums.CustomEvent;
//import org.oizehsgl.spring.statemachine.enums.CustomState;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.statemachine.StateMachinePersist;
//import org.springframework.statemachine.data.redis.RedisStateMachinePersister;
//import org.springframework.stereotype.Component;
//
///**
// * Redis-状态机持久化接口
// *
// * @author oizehsgl
// */
//@Component
//public class RedisDemoStateMachinePersister
//    extends RedisStateMachinePersister<CustomState, CustomEvent> {
//  public RedisDemoStateMachinePersister(
//      @Qualifier(RedisRepositoryDemoStateMachinePersist.BEAN_NAME)
//          StateMachinePersist<CustomState, CustomEvent, String> stateMachinePersist) {
//    super(stateMachinePersist);
//  }
//}
