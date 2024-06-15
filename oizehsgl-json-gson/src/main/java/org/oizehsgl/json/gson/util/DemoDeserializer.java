package org.oizehsgl.json.gson.util;


import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import lombok.Builder;
import lombok.Data;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 示例反序列化解析器
 *
 * @author oizehsgl
 */
@Data
@Builder
public class DemoDeserializer implements JsonDeserializer<List<?>> {
  @Override
  public List<?> deserialize(
          JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
    if (jsonElement.isJsonArray()) {
      JsonArray jsonArray = jsonElement.getAsJsonArray();
      if (jsonArray.isEmpty()) {
        return Collections.emptyList();
      }
      List<?> resultList = new ArrayList<>();
      for (JsonElement element : jsonArray) {
        resultList.add(jsonDeserializationContext.deserialize(element, type));
      }
      return resultList;
    } else {
      return Collections.emptyList();
    }
  }
}
