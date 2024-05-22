package org.oizehsgl.spring.statemachine.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 状态
 *
 * @author oizehsgl
 */
@Getter
@RequiredArgsConstructor
public enum CustomState {
  S1(1, "一"),
  S2(2, "二"),
  S3(3, "三"),
  S4(4, "四"),
  S5(5, "五"),
  S6(6, "六"),
  S7(7, "七"),
  S8(8, "八"),
  S9(9, "九"),
  ;
  private final Integer code;
  private final String desc;
}
