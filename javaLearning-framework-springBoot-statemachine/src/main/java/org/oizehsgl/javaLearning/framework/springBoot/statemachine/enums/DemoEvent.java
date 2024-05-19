package org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 订单事件
 *
 * @author oizehsgl
 */
@Getter
@RequiredArgsConstructor
public enum DemoEvent {
  E1(1, "壹"),
  E2(2, "贰"),
  E3(3, "叁"),
  E4(4, "肆"),
  E5(5, "伍"),
  E6(6, "陆"),
  E7(7, "柒"),
  E8(8, "捌"),
  E9(9, "玖"),
  ;
  private final Integer code;
  private final String desc;
}
