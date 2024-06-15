package org.oizehsgl.sm.spring.statemachine.persist.redis;

import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class CustomRedisRepositoryStateMachinePersist
    extends RepositoryStateMachinePersist<CustomState, CustomEvent> {
  public static final String BEAN_NAME = "customRedisRepositoryStateMachinePersist";

  /**
   * Instantiates a new repository state machine persist.
   *
   * @param repository the repository
   */
  public CustomRedisRepositoryStateMachinePersist(
      @Qualifier(CustomRedisStateMachineContextRepository.BEAN_NAME)
      StateMachineContextRepository<
                        CustomState, CustomEvent, StateMachineContext<CustomState, CustomEvent>>
              repository) {
    super(repository);
  }
}
