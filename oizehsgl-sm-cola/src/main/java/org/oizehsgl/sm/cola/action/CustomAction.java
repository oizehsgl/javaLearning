package org.oizehsgl.sm.cola.action;

import com.alibaba.cola.statemachine.Action;
import org.oizehsgl.sm.cola.context.CustomContext;
import org.oizehsgl.sm.cola.event.CustomEvent;
import org.oizehsgl.sm.cola.state.CustomState;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class CustomAction implements Action<CustomState, CustomEvent, CustomContext> {

  @Override
  public void execute(CustomState from, CustomState to, CustomEvent event, CustomContext context) {
    System.out.println("---------------------------------------------------------------");
    System.out.println("33333333333333333333333333333333333333333333333333333333333333333333");
    System.out.printf(
        "准备转换: %s -> %s [event:%s] [message:%s]%n", from, to, event, context.getMessage());
  }
}
