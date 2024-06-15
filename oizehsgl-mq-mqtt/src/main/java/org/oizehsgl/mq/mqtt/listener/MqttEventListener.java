package org.oizehsgl.mq.mqtt.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.integration.mqtt.event.MqttMessageDeliveredEvent;
import org.springframework.integration.mqtt.event.MqttMessageSentEvent;
import org.springframework.integration.mqtt.event.MqttSubscribedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * mqtt事件监听
 *
 * @author oizehsgl
 */
@Slf4j
@Component
public class MqttEventListener {
  /**
   * 当async和async事件(async - events)都为true时, 将发出MqttMessageSentEvent
   * 它包含消息、主题、客户端库生成的消息id、clientId和clientInstance（每次连接客户端时递增）
   */
  @EventListener(MqttMessageSentEvent.class)
  public void mqttMessageSentEventListener(MqttMessageSentEvent event) {
    log.info("发送信息[date<{}>,info<{}>]", new Date(), event);
  }

  /**
   * 当async和async事件(async - events)都为true时, 将发出MqttMessageDeliveredEvent
   * 当客户端库确认传递时，将发出MqttMessageDeliveredEvent。它包含messageId、clientId和clientInstance，使传递与发送相关。
   */
  @EventListener(MqttMessageDeliveredEvent.class)
  public void mqttMessageDeliveredEventListener(MqttMessageDeliveredEvent event) {
    log.info("发送成功信息[date<{}>,info<{}>]", new Date(), event);
  }

  /** 成功订阅到主题，MqttSubscribedEvent事件就会被触发(多个主题,多次触发) */
  @EventListener(MqttSubscribedEvent.class)
  public void mqttSubscribedEventListener(MqttSubscribedEvent event) {
    log.info("订阅成功信息[date<{}>,info<{}>]", new Date(), event);
  }
}
