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
  // 初始状态
  INITIAL(0, "初始状态"),
  // 区域1
  R1(0, "区域1"),
  R1A(0, "区域1A"),
  R1B(0, "区域1B"),
  R1C(0, "区域1C"),
  R1D(0, "区域1D"),
  R1E(0, "区域1E"),
  R1F(0, "区域1F"),
  // 区域2
  R2(0, "区域2"),
  // 区域2ABC
  R2A(0, "区域2A"),
  R2B(0, "区域2B"),
  R2C(0, "区域2C"),
  // 区域2XYZ
  R2X(0, "区域2X"),
  R2Y(0, "区域2Y"),
  R2Z(0, "区域2Z"),
  // 为状态
  HISTORY(0, "历史状态"),
  CHOICE(0, "选择状态"),
  JUNCTION(0, "联结状态"),
  FORK(0, "分流状态"),
  JOIN(0, "合流状态"),
  // 结束状态
  END(0, "结束状态"),
  ;
  private final Integer code;
  private final String desc;
}
