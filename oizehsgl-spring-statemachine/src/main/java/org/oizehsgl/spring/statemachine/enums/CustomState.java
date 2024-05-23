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
  S1A(1, "一A"),
  S1B(1, "一B"),
  S1C(1, "一C"),
  S1D(1, "一D"),
  S1ENTRY(1, "一entry"),
  S1EXIT(1, "一exit"),
  S2(2, "二"),
  S2A(2, "二A"),
  S2B(2, "二B"),
  S2C(2, "二C"),
  S2D(2, "二D"),
  S2ENTRY(2, "二entry"),
  S2EXIT(2, "二exit"),
  S3(3, "三"),
  S4(4, "四"),
  S5(5, "五"),
  S6(6, "六"),
  S7(7, "七"),
  S8(8, "八"),
  S9(9, "九"),
  INITIAL(0, "初始状态"),
  HISTORY(0, "历史状态"),
  CHOICE(0, "选择状态"),
  JUNCTION(0, "联结状态"),
  FORK(0, "分流状态"),
  JOIN(0, "合流状态"),
  END(0, "结束状态"),
  ;
  private final Integer code;
  private final String desc;
}
