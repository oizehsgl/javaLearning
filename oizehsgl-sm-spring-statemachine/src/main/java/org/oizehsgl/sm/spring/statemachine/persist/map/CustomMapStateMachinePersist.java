package org.oizehsgl.sm.spring.statemachine.persist.map;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.sm.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.sm.spring.statemachine.enums.CustomState;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Map状态机持久化抽象
 *
 * @author oizehsgl
 */
@Slf4j
@Data
@Component(CustomMapStateMachinePersist.BEAN_NAME)
public class CustomMapStateMachinePersist
    implements StateMachinePersist<CustomState, CustomEvent, String> {
  public static final String BEAN_NAME = "customMapStateMachinePersist";

  private final Map<String, StateMachineContext<CustomState, CustomEvent>> contexts =
      new ConcurrentHashMap<>();

  @Override
  public void write(StateMachineContext<CustomState, CustomEvent> context, String contextObj) {
    log.info("状态机持久化(写入)[key<{}>]", contextObj);
    contexts.put(contextObj, context);
  }

  @Override
  public StateMachineContext<CustomState, CustomEvent> read(String contextObj) {
    log.info("状态机持久化(读取)[key<{}>]", contextObj);
    return contexts.get(contextObj);
  }
}
