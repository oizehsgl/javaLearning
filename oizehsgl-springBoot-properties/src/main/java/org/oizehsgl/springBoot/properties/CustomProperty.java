package org.oizehsgl.springBoot.properties;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;

/**
 * @author oizehsgl
 */
@Data
@Validated
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

  @NotNull
  //@NotEmpty
  private String p5;
  private SubProperty subProperty = new SubProperty();

  @Data
  public class SubProperty {
    private String p1;
    private String p2;
    private String p5;

    public String getP2() {
      return CustomProperty.this.p2 + p2;
    }
  }
}
