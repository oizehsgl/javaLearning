package org.oizehsgl.spring.statemachine.persist.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.spring.statemachine.enums.CustomEvent;
import org.oizehsgl.spring.statemachine.enums.CustomState;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.stereotype.Component;

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
  public static final String BEAN_NAME = "mapDemoStateMachinePersist";

  private final Map<String, StateMachineContext<CustomState, CustomEvent>> contexts =
      new ConcurrentHashMap<>();

  @Override
  public void write(StateMachineContext<CustomState, CustomEvent> context, String contextObj)
      throws Exception {
    log.info("状态机持久化(写入)[key<{}>]", contextObj);
    contexts.put(contextObj, context);
  }

  @Override
  public StateMachineContext<CustomState, CustomEvent> read(String contextObj) throws Exception {
    log.info("状态机持久化(读取)[key<{}>]", contextObj);
    return contexts.get(contextObj);
  }
}
