package org.oizehsgl.sm.spring.statemachine.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 事件
 *
 * @author oizehsgl
 */
@Getter
@RequiredArgsConstructor
public enum CustomEvent {
  INITIAL(0, "初始化"),
  NEXT(0, "下一个"),
  SUB_NEXT(0, "子区域下一个"),
  SUB_NEXT1(0, "子区域1下一个"),
  SUB_NEXT2(0, "子区域2下一个"),
  R1(0, "区域1"),
  R2(0, "区域2"),
  CHOICE(0, "选择"),
  JUNCTION(0, "联结"),
  HISTORY(0, "历史"),
  FORK(0, "分流"),
  JOIN(0, "合流"),
  ENTRY(0, "进入"),
  EXIT(0, "退出"),
  ;
  private final Integer code;
  private final String desc;
}
