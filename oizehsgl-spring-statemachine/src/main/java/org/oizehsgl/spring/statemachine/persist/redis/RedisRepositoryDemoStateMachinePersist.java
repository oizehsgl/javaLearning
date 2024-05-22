//package org.oizehsgl.spring.statemachine.persist.redis;
//
//import org.oizehsgl.spring.statemachine.enums.CustomEvent;
//import org.oizehsgl.spring.statemachine.enums.CustomState;
//import org.springframework.statemachine.StateMachineContext;
//import org.springframework.statemachine.StateMachineContextRepository;
//import org.springframework.statemachine.persist.RepositoryStateMachinePersist;
//import org.springframework.stereotype.Component;
//
///**
// * Redis-持久化状态机接口
// *
// * @author oizehsgl
// */
//@Component
//public class RedisRepositoryDemoStateMachinePersist
//    extends RepositoryStateMachinePersist<CustomState, CustomEvent> {
//  public static final String BEAN_NAME = "redisRepositoryDemoStateMachinePersist";
//
//  /**
//   * Instantiates a new repository state machine persist.
//   *
//   * @param repository the repository
//   */
//  public RedisRepositoryDemoStateMachinePersist(
//      StateMachineContextRepository<CustomState, CustomEvent, StateMachineContext<CustomState, CustomEvent>>
//          repository) {
//    super(repository);
//  }
//}
