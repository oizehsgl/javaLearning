package org.oizehsgl.springBoot.properties;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author oizehsgl
 */
@Data
@Configuration
@ConfigurationProperties("custom.property")
public class CustomProperty {
  private String p1;
  private String p2;
  private SubProperty subProperty = new SubProperty();

  @Data
  public class SubProperty {
    private String p1;
    private String p2;

    public String getP2() {
      return CustomProperty.this.p2+p2;
    }
  }
}
