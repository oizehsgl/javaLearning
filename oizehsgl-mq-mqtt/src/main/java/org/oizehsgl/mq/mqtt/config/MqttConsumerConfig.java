package org.oizehsgl.mq.mqtt.config;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.oizehsgl.mq.mqtt.constant.MqttConstant;
import org.oizehsgl.mq.mqtt.handler.MqttCustomerHandler;
import org.oizehsgl.mq.mqtt.property.MqttConsumerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.util.UUID;

/**
 * mqtt消费者配置类
 *
 * @author oizehsgl
 */
@Slf4j
@Configuration
public class MqttConsumerConfig {
  @Resource private MqttConsumerProperties mqttConsumerProperties;
  @Resource private MqttCustomerHandler mqttCustomerHandler;

  /**
   * mqtt连接选项
   *
   * @return {@link MqttConnectOptions}
   */
  public MqttConnectOptions getMqttConnectOptions() {
    // MQTT的连接设置
    MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
    // 设置连接的用户名
    mqttConnectOptions.setUserName(mqttConsumerProperties.getUsername());
    // 设置连接的密码
    mqttConnectOptions.setPassword(mqttConsumerProperties.getPassword().toCharArray());
    // 设置是否清空session,这里如果设置为false表示服务器会保留客户端的连接记录，
    // 把配置里的 cleanSession 设为false，客户端掉线后 服务器端不会清除session，
    // 当重连后可以接收之前订阅主题的消息。当客户端上线后会接受到它离线的这段时间的消息
    mqttConnectOptions.setCleanSession(false);
    // 设置发布端地址,多个用逗号分隔, 如:tcp://1.1.1.1:1883,tcp://2.2.2.2:1883
    // 当第一个1.1.1.1连接上后,2.2.2.2不会在连,如果1.1.1.1挂掉后,重试连1.1.1.1几次失败后,会自动去连接2.2.2.2
    mqttConnectOptions.setServerURIs(mqttConsumerProperties.getUrls());
    // 设置超时时间 单位为秒
    mqttConnectOptions.setConnectionTimeout(mqttConsumerProperties.getTimeout());
    // 设置会话心跳时间 单位为秒 服务器会每隔1.5*interval秒的时间向客户端发送消息判断客户端是否在线,但这个方法并没有重连的机制
    mqttConnectOptions.setKeepAliveInterval(mqttConsumerProperties.getKeepAliveInterval());
    // 断开后重连，但这个方法并没有重新订阅的机制
    // 在尝试重新连接之前，它将首先等待1秒，对于每次失败的重新连接尝试，延迟将加倍，直到达到2分钟，此时延迟将保持在2分钟。
    mqttConnectOptions.setAutomaticReconnect(true);
    // 设置“遗嘱”消息的话题，若客户端与服务器之间的连接意外中断，服务器将发布客户端的“遗嘱”消息。
    mqttConnectOptions.setWill(
        mqttConsumerProperties.getWillTopic(),
        mqttConsumerProperties.getWillContent().getBytes(),
        2,
        false);
    mqttConnectOptions.setMaxInflight(1000000);
    return mqttConnectOptions;
  }

  /**
   * mqtt信道
   *
   * @return {@link MessageChannel}
   */
  @Bean(name = MqttConstant.Channel.IN)
  public MessageChannel mqttInboundChannel() {
    return new DirectChannel();
  }

  /**
   * mqtt订阅绑定
   *
   * @return {@link MessageProducer}
   */
  @Bean
  public MessageProducer inbound() {
    DefaultMqttPahoClientFactory defaultMqttPahoClientFactory = new DefaultMqttPahoClientFactory();
    defaultMqttPahoClientFactory.setConnectionOptions(getMqttConnectOptions());

    // 可以同时消费（订阅）多个Topic
    // clientId每个连接必须唯一,否则,两个相同的clientId相互挤掉线
    MqttPahoMessageDrivenChannelAdapter mqttPahoMessageDrivenChannelAdapter =
        new MqttPahoMessageDrivenChannelAdapter(
            mqttConsumerProperties.getClientIdPrefix() + UUID.randomUUID(),
            defaultMqttPahoClientFactory,
            mqttConsumerProperties.getTopics());
    // 设置完成超时时间
    // mqttPahoMessageDrivenChannelAdapter.setCompletionTimeout(30000);
    // 消息转换器
    DefaultPahoMessageConverter defaultPahoMessageConverter = new DefaultPahoMessageConverter();
    // 按字节接收消息
    defaultPahoMessageConverter.setPayloadAsBytes(true);

    mqttPahoMessageDrivenChannelAdapter.setConverter(defaultPahoMessageConverter);
    // 设置质量
    mqttPahoMessageDrivenChannelAdapter.setQos(mqttConsumerProperties.getQos());
    // 设置订阅通道
    mqttPahoMessageDrivenChannelAdapter.setOutputChannel(mqttInboundChannel());

    return mqttPahoMessageDrivenChannelAdapter;
  }

  /**
   * mqtt消息处理
   *
   * @return {@link MessageHandler}
   */
  @Bean
  @ServiceActivator(inputChannel = MqttConstant.Channel.IN)
  public MessageHandler handler() {
    return mqttCustomerHandler;
  }
}
