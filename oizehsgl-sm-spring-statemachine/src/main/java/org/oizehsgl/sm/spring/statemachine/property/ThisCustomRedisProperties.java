package org.oizehsgl.sm.spring.statemachine.property;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

/**
 * @author oizehsgl
 */
@Getter
@Setter
@Validated
@Configuration
@ConfigurationProperties(prefix = "this.custom.redis")
public class ThisCustomRedisProperties {
  /** 前缀 */
  @NotNull private String prefix;

  @NotNull private StateMachine stateMachine = new StateMachine();

  @Getter
  @Setter
  @Validated
  public class StateMachine {
    /** 前缀 */
    @NotNull private String prefix;
    public @NotNull String getPrefix() {
      return ThisCustomRedisProperties.this.prefix + this.prefix;
    }
  }
}
