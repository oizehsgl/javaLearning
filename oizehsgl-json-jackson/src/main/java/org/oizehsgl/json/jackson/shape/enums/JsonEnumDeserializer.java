package org.oizehsgl.json.jackson.shape.enums;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import lombok.SneakyThrows;

/**
 * @author oizehsgl
 */
public class JsonEnumDeserializer<T extends Enum<T>> extends StdDeserializer<T> {
  public JsonEnumDeserializer() {
    super(Enum.class);
  }

  // protected JsonEnumDeserializer(JavaType valueType) {
  //  super(valueType);
  // }

  // protected JsonEnumDeserializer(StdDeserializer<?> src) {
  //  super(src);
  // }

  @SneakyThrows
  @Override
  public T deserialize(JsonParser p, DeserializationContext ctxt)
      throws IOException, JacksonException {
    JsonNode node = p.getCodec().readTree(p);
    String name = node.get("name").asText();
    String className = node.get("className").asText();
    // Class<T> clazz = node.get("clazz");
    // Class<T> tClass = (Class<T>) Class.forName("org.oizehsgl.json.jackson.shape.enums.DemoEnum");
    // return T.valueOf(tClass, name);
    // return T.valueOf(getClass(),name);
    Class<T> tClass = (Class<T>) Class.forName(className);
    return T.valueOf(tClass, name);
  }
}
