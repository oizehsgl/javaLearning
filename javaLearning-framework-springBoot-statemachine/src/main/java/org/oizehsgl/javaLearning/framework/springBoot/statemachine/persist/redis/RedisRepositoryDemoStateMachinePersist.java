package org.oizehsgl.javaLearning.framework.springBoot.statemachine.persist.redis;

import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachineContextRepository;
import org.springframework.statemachine.persist.RepositoryStateMachinePersist;
import org.springframework.stereotype.Component;

/**
 * Redis-持久化状态机接口
 *
 * @author oizehsgl
 */
@Component
public class RedisRepositoryDemoStateMachinePersist
    extends RepositoryStateMachinePersist<DemoState, DemoEvent> {
  public static final String BEAN_NAME = "redisRepositoryDemoStateMachinePersist";

  /**
   * Instantiates a new repository state machine persist.
   *
   * @param repository the repository
   */
  public RedisRepositoryDemoStateMachinePersist(
      StateMachineContextRepository<DemoState, DemoEvent, StateMachineContext<DemoState, DemoEvent>>
          repository) {
    super(repository);
  }
}
