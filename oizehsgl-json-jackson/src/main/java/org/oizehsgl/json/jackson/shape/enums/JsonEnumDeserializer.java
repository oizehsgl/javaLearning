package org.oizehsgl.json.jackson.shape.enums;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import lombok.SneakyThrows;

/**
 * @author oizehsgl
 */
public class JsonEnumDeserializer<T extends Enum<T>> extends StdDeserializer<T> {
  public JsonEnumDeserializer() {
    super(Enum.class);
  }

  @SneakyThrows
  @Override
  public T deserialize(JsonParser p, DeserializationContext ctxt) {
    JsonNode node = p.getCodec().readTree(p);
    String name = node.get("name").asText();
    String className = node.get("className").asText();
    Class<?> clazz = Class.forName(className);
    return T.valueOf((Class<T>) clazz, name);
  }
}
