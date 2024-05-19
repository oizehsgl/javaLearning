package org.oizehsgl.javaLearning.library.gson.util;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

/**
 * 日期时间序列化
 *
 * @author oizehsgl
 */
@Slf4j
@Data
@Builder
// TODO: 这里添加无参构造注解会报错
// @NoArgsConstructor
// @AllArgsConstructor
public class DemoDateTimeSerializer implements JsonSerializer<Date>, JsonDeserializer<Date> {
  private final String datetimeFormat;

  @Override
  public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
    String json = DateFormatUtils.format(date, datetimeFormat);
    return new JsonPrimitive(json);
  }

  @Override
  public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    try {
      return DateUtils.parseDate(json.getAsString(), datetimeFormat);
    } catch (ParseException e) {
      log.error("json日期反序列化异常[json<{}>]", json);
      return null;
    }
  }
}
