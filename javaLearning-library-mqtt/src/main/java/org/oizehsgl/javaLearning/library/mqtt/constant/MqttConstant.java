package org.oizehsgl.javaLearning.library.mqtt.constant;

/**
 * mqttConstant
 *
 * @author oizehsgl
 * @since 3/21/23
 */
public abstract class MqttConstant {
    public static abstract class Channel {
        /**
         * 订阅信道的bean名称
         */
        public final static String IN = "mqttInboundChannel";
        /**
         * 发布信道的bean名称
         */
        public final static String OUT = "mqttOutboundChannel";
    }
}
