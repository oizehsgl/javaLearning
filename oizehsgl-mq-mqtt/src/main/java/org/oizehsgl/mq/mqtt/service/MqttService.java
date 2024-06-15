package org.oizehsgl.mq.mqtt.service;

import org.oizehsgl.mq.mqtt.constant.MqttConstant;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

/**
 * mqtt网关
 *
 * @author oizehsgl
 */
@Component
@MessagingGateway(defaultRequestChannel = MqttConstant.Channel.OUT)
public interface MqttService {
  /**
   * 主题,质量,负载
   *
   * @param topic 主题
   * @param qos 质量0: 消费次数<=1 质量1: 消费次数>=1 质量2: 消费次数=1
   * @param retained 保留
   * @param payload 负载
   */
  void send(
      @Header(MqttHeaders.TOPIC) String topic,
      @Header(MqttHeaders.QOS) int qos,
      @Header(MqttHeaders.RETAINED) boolean retained,
      String payload);

  /**
   * 负载
   *
   * @param payload 负载
   */
  void send(String payload);
}
