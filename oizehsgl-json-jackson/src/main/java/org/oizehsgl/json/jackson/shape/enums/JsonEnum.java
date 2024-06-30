package org.oizehsgl.json.jackson.shape.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.annotation.*;

/**
 * @author oizehsgl
 */
@JsonDeserialize(using = JsonEnumDeserializer.class)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public interface JsonEnum<T extends Enum<T>> {
  String name();

  default String getName() {
    return name();
  }

  // default String getClassName(T t) {
  //  //return "org.oizehsgl.json.jackson.shape.enums.DemoEnum";
  //  return getClass().getName();
  // }

  // String getClassName();

  default String getClassName() {
    return getClass().getName();
  }
}
