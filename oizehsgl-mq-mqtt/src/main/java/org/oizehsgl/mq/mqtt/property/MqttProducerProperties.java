package org.oizehsgl.mq.mqtt.property;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * mqtt生产者配置属性
 *
 * @author oizehsgl
 */
@Data
@Component
@ConfigurationProperties(prefix = "mqtt.producer")
public class MqttProducerProperties {
  @NotEmpty private String[] urls;
  @NotNull private String username;
  @NotNull private String password;
  @NotNull private String clientIdPrefix;
  @NotNull private Integer qos;
  @NotNull private Integer timeout;
  @NotNull private Integer keepAliveInterval;
  @NotEmpty private String[] topics;
  @NotNull private String willTopic;
  @NotNull private String willContent;
}
