package org.oizehsgl.json.jackson.shape.enums;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.oizehsgl.json.jackson.util.CustomJacksonUtils;

/**
 * @author oizehsgl
 */
@Slf4j
class CustomEnumTest {

  @Test
  public void serializer() throws JsonProcessingException {
    CustomEnum customEnum = CustomEnum.ONE;
    String s = CustomJacksonUtils.DEFAULT.writeValueAsString(customEnum);
    log.info("序列化[E<{}>,S<{}>]", customEnum, s);
    CustomEnum newCustomEnum = CustomJacksonUtils.DEFAULT.readValue(s, CustomEnum.class);
    log.info("反序列化[E<{}>,S<{}>]", newCustomEnum, s);
  }
}
