package org.oizehsgl.springBoot2.openapi.vo;

import lombok.Builder;
import lombok.Data;

/**
 * 示例vo
 *
 * @author oizehsgl
 */
@Data
@Builder
public class DemoVo {
  private String name;
  private Integer age;
}
