package org.oizehsgl.javaLearning.library.mqtt.property;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


/**
 * mqtt消费者配置属性
 *
 * @author yueyuanzhi
 */
@Data
@Component
@ConfigurationProperties(prefix = "mqtt.consumer")
public class MqttConsumerProperties {
    @NotEmpty
    private String[] urls;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String clientIdPrefix;
    @NotNull
    private Integer qos;
    @NotNull
    private Integer timeout;
    @NotNull
    private Integer keepAliveInterval;
    @NotEmpty
    private String[] topics;
    @NotNull
    private String willTopic;
    @NotNull
    private String willContent;
}