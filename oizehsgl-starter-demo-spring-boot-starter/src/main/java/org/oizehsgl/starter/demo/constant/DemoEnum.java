package org.oizehsgl.starter.demo.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @author oizehsgl
 */
@Getter
@RequiredArgsConstructor
public enum DemoEnum {
  E1(1, "e1"),
  E2(2, "e2"),
  E3(3, "e3"),
  ;
  private final Integer code;
  private final String desc;
}
