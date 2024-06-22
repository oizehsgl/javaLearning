package org.oizehsgl.util.hutool;

import static org.junit.jupiter.api.Assertions.*;

import cn.hutool.json.JSONUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

/**
 * @author oizehsgl
 */
// @SpringBootTest
class DemoDtoTest {
  DemoDto demoDto1 = DemoDto.builder().property("ppp").alias("aaa").build();
  DemoDto demoDto2 = DemoDto.builder().alias("aaa").build();
  String propertyTest1 =
      """
        {"Pro":"ppp"}
        """;
  String aliasTest1 =
      """
          {"a":"aaa"}
          """;
  String aliasTest2 =
      """
          {"ALIAS":"aaa"}
          """;

  @Test
  public void test() throws JsonProcessingException {
    ObjectMapper objectMapper = new ObjectMapper();
    System.out.println(objectMapper.readValue(aliasTest1, DemoDto.class));
    System.out.println(objectMapper.readValue(aliasTest2, DemoDto.class));
    System.out.println(objectMapper.readValue(propertyTest1, DemoDto.class));
    System.out.println(objectMapper.writeValueAsString(demoDto1));
    System.out.println(objectMapper.writeValueAsString(demoDto2));
    System.out.println(JSONUtil.toBean(aliasTest1, DemoDto.class));
    System.out.println(JSONUtil.toBean(aliasTest2, DemoDto.class));
    System.out.println(JSONUtil.toBean(propertyTest1, DemoDto.class));
    System.out.println(JSONUtil.toJsonStr(demoDto1));
    System.out.println(JSONUtil.toJsonStr(demoDto2));
  }
}
