package org.oizehsgl.javaLearning.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author oizehsgl
 */
@Data
@ConfigurationProperties(value = "ttt.xxx")
public class RedisTestProperties {
  /** 是一个测试的属性 */
  private String testA = "YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY";

  private String testB = "";
  private String testC;
}
