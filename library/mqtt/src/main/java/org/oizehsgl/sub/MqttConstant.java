package org.oizehsgl.sub;

/**
 * mqttConstant
 *
 * @author oizehsgl
 * @since 3/21/23
 */
public final class MqttConstant {
    private MqttConstant() {
    }

    public final static class Channel {
        /**
         * 订阅的bean名称
         */
        public final static String IN = "mqttInboundChannel";
        /**
         * 发布的bean名称
         */
        public final static String OUT = "mqttOutboundChannel";
    }
}
