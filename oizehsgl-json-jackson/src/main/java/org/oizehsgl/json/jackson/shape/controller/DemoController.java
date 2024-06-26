package org.oizehsgl.json.jackson.shape.controller;


import org.oizehsgl.json.jackson.shape.enums.DemoEnum;
import org.oizehsgl.json.jackson.shape.enums.DemoThirdPartEnum;
import org.oizehsgl.json.jackson.shape.vo.DemoVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 示例控制层
 *
 * @author oizehsgl
 */
@RestController
public class DemoController {

  @GetMapping("/enum")
  public ResponseEntity<DemoVo> getEnum(DemoVo demoVo) {
    if (Objects.isNull(demoVo.getDemoEnum()) && Objects.isNull(demoVo.getDemoThirdPartEnum())) {
      demoVo =
          DemoVo.builder().demoEnum(DemoEnum.ONE).demoThirdPartEnum(DemoThirdPartEnum.TWO).build();
    }
    return ResponseEntity.ok(demoVo);
  }
}
