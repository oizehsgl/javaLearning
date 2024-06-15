package org.oizehsgl.json.jackson.shape.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 示例第三方枚举
 *
 * @author oizehsgl
 */
@Getter
@RequiredArgsConstructor
public enum DemoThirdPartEnum implements IBaseEnum {
  ONE(1, "壹"),
  TWO(2, "贰"),
  THREE(3, "叁");
  private final Integer code;
  private final String desc;

  @Override
  public Object getId() {
    return getCode();
  }
}
