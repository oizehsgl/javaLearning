package org.oizehsgl.javaLearning.framework.springBoot.statemachine.persist.map;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoEvent;
import org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums.DemoState;
import org.springframework.statemachine.StateMachineContext;
import org.springframework.statemachine.StateMachinePersist;
import org.springframework.stereotype.Component;

/**
 * Map-状态机持久化接口类
 *
 * @author oizehsgl
 */
@Slf4j
@Data
@Component(MapDemoStateMachinePersist.BEAN_NAME)
public class MapDemoStateMachinePersist
    implements StateMachinePersist<DemoState, DemoEvent, String> {
  public static final String BEAN_NAME = "mapDemoStateMachinePersist";

  private final Map<String, StateMachineContext<DemoState, DemoEvent>> contexts =
      new ConcurrentHashMap<>();

  @Override
  public void write(StateMachineContext<DemoState, DemoEvent> context, String contextObj)
      throws Exception {
    log.info("状态机持久化(写入)[key<{}>]", contextObj);
    contexts.put(contextObj, context);
  }

  @Override
  public StateMachineContext<DemoState, DemoEvent> read(String contextObj) throws Exception {
    log.info("状态机持久化(读取)[key<{}>]", contextObj);
    return contexts.get(contextObj);
  }
}
