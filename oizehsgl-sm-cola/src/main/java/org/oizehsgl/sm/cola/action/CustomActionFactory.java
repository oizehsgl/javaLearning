package org.oizehsgl.sm.cola.action;

import org.oizehsgl.sm.cola.context.CustomContext;
import org.oizehsgl.sm.cola.event.CustomEvent;
import org.oizehsgl.sm.cola.state.CustomState;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class CustomActionFactory {
  // 执行转换前的准备动作
  public void prepare(CustomState from, CustomState to, CustomEvent event, CustomContext context) {
    System.out.printf(
        "准备转换: %s -> %s [event:%s] [message:%s]%n", from, to, event, context.getMessage());
  }

  // 执行转换动作
  public void execute(CustomState from, CustomState to, CustomEvent event, CustomContext context) {
    System.out.printf(
        "执行转换: %s -> %s [event:%s] [message:%s]%n", from, to, event, context.getMessage());
  }

  // 执行转换后的清理动作
  public void clean(CustomState from, CustomState to, CustomEvent event, CustomContext context) {
    System.out.printf(
        "结束转换: %s -> %s [event:%s] [message:%s]%n", from, to, event, context.getMessage());
  }
}
