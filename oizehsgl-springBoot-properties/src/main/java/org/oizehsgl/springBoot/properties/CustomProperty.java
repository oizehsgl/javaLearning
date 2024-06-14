package org.oizehsgl.springBoot.properties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
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
  private SubProperty subProperty;
  @Data
  public static class SubProperty {
    private String p1;
    private String p2;
  }
}
