package org.oizehsgl.json.jackson.shape.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.annotation.*;

/**
 * @author oizehsgl
 */
@JsonDeserialize(using = JsonEnumDeserializer.class)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public interface JsonEnum {
  String name();

  default String getName() {
    return name();
  }

  default String getClassName() {
    return getClass().getName();
  }
}
