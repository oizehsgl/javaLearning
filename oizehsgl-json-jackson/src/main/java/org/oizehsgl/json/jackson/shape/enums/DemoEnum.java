package org.oizehsgl.json.jackson.shape.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * 示例枚举
 *
 * @author oizehsgl
 */
@Getter
@RequiredArgsConstructor
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DemoEnum {
  ONE(1, "一"),
  TWO(2, "二"),
  THREE(3, "三");
  private final Integer code;
  private final String desc;

  @JsonCreator
  public static DemoEnum getEnum(Integer code) {
    return Arrays.stream(DemoEnum.values())
        .filter(e -> e.getCode().equals(code))
        .findFirst()
        .orElse(DemoEnum.ONE);
  }
}
