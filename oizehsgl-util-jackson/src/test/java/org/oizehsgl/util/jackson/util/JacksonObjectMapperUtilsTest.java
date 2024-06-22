package org.oizehsgl.util.jackson.util;

import static org.junit.jupiter.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.oizehsgl.util.jackson.model.DemoDto;

/**
 * @author oizehsgl
 */
class JacksonObjectMapperUtilsTest {
  DemoDto demoDto = DemoDto.builder().property("ppp").alias("aaa").build();

  @Test
  public void test() throws JsonProcessingException {
    String j = JacksonObjectMapperUtils.DEFAULT.writeValueAsString(demoDto);
    DemoDto newDemoDto = JacksonObjectMapperUtils.DEFAULT.readValue(j, DemoDto.class);
    System.out.println(newDemoDto);
  }
}
