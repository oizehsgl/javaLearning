package org.oizehsgl.springBoot.properties;

import lombok.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

/**
 * @author oizehsgl
 */
@Data
@Configuration
@ConfigurationProperties("custom.property")
public class CustomProperty {
  private String p1;
  private String p2;

  /** 不建议这样使用 */
  public static String PP3;

  public void setP3(String p3) {
    PP3 = p3;
  }

  /** 如果不配置直接报错 */
  @Value("${custom.property.other.p4}")
  private String p4;

  private SubProperty subProperty = new SubProperty();

  @Data
  public class SubProperty {
    private String p1;
    private String p2;

    public String getP2() {
      return CustomProperty.this.p2 + p2;
    }
  }
}
