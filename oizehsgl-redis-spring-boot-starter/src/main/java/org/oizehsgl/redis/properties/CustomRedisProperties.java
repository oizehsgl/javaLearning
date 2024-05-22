package org.oizehsgl.redis.properties;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

/**
 * @author oizehsgl
 */
@Getter
@Setter
@Validated
@ConfigurationProperties("custom.redis")
public class CustomRedisProperties {
  /** 前缀 */
  @NotNull private String prefix;
}
