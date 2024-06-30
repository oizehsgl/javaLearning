package org.oizehsgl.json.jackson.shape.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 示例枚举
 *
 * @author oizehsgl
 */
@Getter
@RequiredArgsConstructor
public enum DemoEnum implements JsonEnum {
  ONE(1, "一"),
  TWO(2, "二"),
  THREE(3, "三");
  private final Integer code;
  private final String desc;
}
