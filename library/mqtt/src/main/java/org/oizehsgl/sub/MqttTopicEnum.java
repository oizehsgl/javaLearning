package org.oizehsgl.sub;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * mqttTopicEnum
 *
 * @author oizehsgl
 * @since 3/24/23
 */
@Getter
@AllArgsConstructor
@ToString
public enum MqttTopicEnum {
    RY("qy"), QY("qy");
    private String name;
}
