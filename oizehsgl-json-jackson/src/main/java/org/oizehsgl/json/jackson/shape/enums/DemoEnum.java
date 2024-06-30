package org.oizehsgl.json.jackson.shape.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 示例枚举
 *
 * @author oizehsgl
 */
@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DemoEnum implements JsonEnum {
  ONE(1, "一"),
  TWO(2, "二"),
  THREE(3, "三");
  private final Integer code;
  private final String desc;

  @JsonCreator
  public static DemoEnum enumOf(String name) {
    return valueOf(name);
  }
}
