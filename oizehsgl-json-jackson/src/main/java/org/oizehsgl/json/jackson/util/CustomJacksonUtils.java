package org.oizehsgl.json.jackson.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * @author oizehsgl
 */
public abstract class CustomJacksonUtils {
  public static final ObjectMapper DEFAULT =
      new ObjectMapper()
          .findAndRegisterModules()
          .registerModule(
              new JavaTimeModule()
                  .addSerializer(
                      LocalDateTime.class,
                      new LocalDateTimeSerializer(
                          DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.systemDefault())))
                  .addDeserializer(
                      LocalDateTime.class,
                      new LocalDateTimeDeserializer(
                          DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.systemDefault()))));
}
