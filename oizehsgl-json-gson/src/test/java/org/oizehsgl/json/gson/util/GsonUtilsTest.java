package org.oizehsgl.json.gson.util;


import com.google.gson.reflect.TypeToken;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.oizehsgl.json.gson.DemoDto;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author oizehsgl
 */
@SpringBootTest
class GsonUtilsTest {
  private DemoDto demoDto;
  private String json;

  @BeforeEach
  void setUp() {
    demoDto =
        DemoDto.builder()
            .expose("expose")
            .serializedName("serializedName")
            .since("since")
            .until("until")
            .build();
    json =
        """
                {"expose":"expose","SERIALIZED_NAME":"serializedName","since":"since"}
                """;
  }

  @Test
  void toJson() {
    String json = GsonUtils.toJson(demoDto);
    System.out.println(json);
  }

  @Test
  void fromJson() {
    DemoDto dto = GsonUtils.fromJson(json, DemoDto.class);
    System.out.println(dto);
  }

  @Test
  void typeToken() {
    List<DemoDto> demoDtoList = new ArrayList<>();
    demoDtoList.add(demoDto);
    demoDtoList.add(demoDto);
    String json = GsonUtils.toJson(demoDtoList);
    List<DemoDto> demoDtos = GsonUtils.fromJson(json, new TypeToken<>() {}.getType());
    System.out.println(demoDtos);
  }
}
