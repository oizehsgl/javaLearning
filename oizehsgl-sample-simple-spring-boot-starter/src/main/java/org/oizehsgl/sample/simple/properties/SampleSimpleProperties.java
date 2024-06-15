package org.oizehsgl.sample.simple.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author oizehsgl
 */
@Data
@ConfigurationProperties("sample.simple")
public class SampleSimpleProperties {
  /** 编码 */
  private String code = "code";

  /** 名称 */
  private String name = "name";
}
