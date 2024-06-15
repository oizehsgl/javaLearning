package org.oizehsgl.mq.mqtt.constant;

/**
 * mqttConstant
 *
 * @author oizehsgl
 * @since 3/21/23
 */
public abstract class MqttConstant {
  public abstract static class Channel {
    /** 订阅信道的bean名称 */
    public static final String IN = "mqttInboundChannel";

    /** 发布信道的bean名称 */
    public static final String OUT = "mqttOutboundChannel";
  }
}
