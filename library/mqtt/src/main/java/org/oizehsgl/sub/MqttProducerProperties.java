package org.oizehsgl.sub;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * mqttProducerProperties
 *
 * @author oizehsgl
 * @since 2022/12/29
 */
@Data
@Component
@ConfigurationProperties(prefix = "mqtt.producer")
public class MqttProducerProperties {
    /**
     * url
     */
    private String url;
    /**
     * mqtt用户
     */
    private String username;
    /**
     * mqtt密码
     */
    private String password;
    /**
     * 客户id
     */
    private String clientId;
    private Integer qos;
    private Integer timeout;
    private Integer keepAlive;
    private String topic;
}