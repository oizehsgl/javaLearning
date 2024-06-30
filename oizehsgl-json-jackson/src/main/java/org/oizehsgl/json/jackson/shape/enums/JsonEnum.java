package org.oizehsgl.json.jackson.shape.enums;

/**
 * @author oizehsgl
 */
public interface JsonEnum {
  String name();

  default String getName() {
    return name();
  }
}
