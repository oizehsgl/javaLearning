package org.oizehsgl.sm.cola.condition;

import com.alibaba.cola.statemachine.Condition;
import org.oizehsgl.sm.cola.context.CustomContext;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 */
@Component
public class CustomCondition implements Condition<CustomContext> {
  @Override
  public boolean isSatisfied(CustomContext customContext) {
    return true;
  }
}
