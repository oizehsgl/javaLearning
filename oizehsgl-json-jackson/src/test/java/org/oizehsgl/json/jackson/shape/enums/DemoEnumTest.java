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
class DemoEnumTest {

  @Test
  public void serializer() throws JsonProcessingException {
    DemoEnum demoEnum = DemoEnum.THREE;
    String s = CustomJacksonUtils.DEFAULT.writeValueAsString(DemoEnum.THREE);
    log.info("序列化[E<{}>,S<{}>]", demoEnum, s);
    DemoEnum newDemoEnum = CustomJacksonUtils.DEFAULT.readValue(s, DemoEnum.class);
    log.info("反序列化[E<{}>,S<{}>]", newDemoEnum, s);
  }
}
