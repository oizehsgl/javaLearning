package org.oizehsgl.sub;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * mqttGateway
 *
 * @author oizehsgl
 * @since 3/21/23
 */
@Component
@MessagingGateway(defaultRequestChannel = MqttConfig.CHANNEL_NAME_OUT)
public interface MqttGateway {
    /**
     * 指定质量主题发送负载
     *
     * @param payload 负载
     * @param topic   主题
     * @param qos     质量 0 表示的是订阅者没收到消息不会再次发送，消息会丢失。1 表示的是会尝试重试，一直到接收到消息，但这种情况可能导致订阅者收到多次重复消息。2 多了一次去重的动作，确保订阅者收到的消息有一次。
     */
    void send(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) int qos, String payload);
}
