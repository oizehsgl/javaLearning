package org.oizehsgl.json.jackson.beta;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author oizehsgl
 */
// TODO: localdatetime反序列化
//@Configuration
public class LocalDatetimeConfiguration {

  @Bean
  public Jackson2ObjectMapperBuilderCustomizer jackson2ObjectMapperBuilderCustomizer() {
    return builder -> {
      DateTimeFormatter dateTimeFormatter =
          DateTimeFormatter.ofPattern(
              DateFormatUtils.ISO_8601_EXTENDED_DATETIME_FORMAT.getPattern());
      builder.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(dateTimeFormatter));
      builder.deserializerByType(
          LocalDateTime.class, new LocalDateTimeDeserializer(dateTimeFormatter));
    };
  }
}
