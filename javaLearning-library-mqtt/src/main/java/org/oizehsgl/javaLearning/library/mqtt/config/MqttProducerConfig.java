package org.oizehsgl.javaLearning.library.mqtt.config;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.oizehsgl.javaLearning.library.mqtt.constant.MqttConstant;
import org.oizehsgl.javaLearning.library.mqtt.property.MqttProducerProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

import java.util.UUID;

/**
 * mqtt生产者配置类
 *
 * @author yueyuanzhi
 */
@Configuration
public class MqttProducerConfig {
    @Autowired
    private MqttProducerProperties mqttProducerProperties;

    /**
     * mqtt连接选项
     *
     * @return {@link MqttConnectOptions}
     */
    public MqttConnectOptions getMqttConnectOptions() {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        // 修复过多发布bug
        mqttConnectOptions.setMaxInflight(1000);
        // 设置是否清空session，
        mqttConnectOptions.setCleanSession(true);
        // 设置连接的用户名
        mqttConnectOptions.setUserName(mqttProducerProperties.getUsername());
        // 设置连接的密码
        mqttConnectOptions.setPassword(mqttProducerProperties.getPassword().toCharArray());
        // 设置url
        mqttConnectOptions.setServerURIs(mqttProducerProperties.getUrls());
        // 设置超时时间 单位为秒
        mqttConnectOptions.setConnectionTimeout(mqttProducerProperties.getTimeout());
        // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送心跳判断客户端是否在线，但这个方法并没有重连的机制
        mqttConnectOptions.setKeepAliveInterval(mqttProducerProperties.getKeepAliveInterval());
        // 设置“遗嘱”消息的话题，若客户端与服务器之间的连接意外中断，服务器将发布客户端的“遗嘱”消息。
        mqttConnectOptions.setWill(mqttProducerProperties.getWillTopic(), mqttProducerProperties.getWillContent().getBytes(), 2, false);
        return mqttConnectOptions;
    }

    /**
     * mqtt消息信道
     *
     * @return {@link MessageChannel}
     */
    @Bean(name = MqttConstant.Channel.OUT)
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }

    /**
     * mqtt消息处理
     *
     * @return {@link MessageHandler}
     */
    @Bean
    @ServiceActivator(inputChannel = MqttConstant.Channel.OUT)
    public MessageHandler mqttOutbound() {
        DefaultMqttPahoClientFactory defaultMqttPahoClientFactory = new DefaultMqttPahoClientFactory();
        defaultMqttPahoClientFactory.setConnectionOptions(getMqttConnectOptions());
        //clientId每个连接必须唯一,否则,两个相同的clientId相互挤掉线
        //String clientIdStr = clientId + new SecureRandom().nextInt(10);
        MqttPahoMessageHandler mqttPahoMessageHandler = new MqttPahoMessageHandler(
                mqttProducerProperties.getClientIdPrefix() + UUID.randomUUID(), defaultMqttPahoClientFactory);
        //async如果为true，则调用方不会阻塞。而是在发送消息时等待传递确认。默认值为false（发送将阻塞，直到确认发送)
        mqttPahoMessageHandler.setAsync(true);
        mqttPahoMessageHandler.setAsyncEvents(true);
        mqttPahoMessageHandler.setDefaultTopic(mqttProducerProperties.getTopics()[0]);
        mqttPahoMessageHandler.setDefaultQos(mqttProducerProperties.getQos());
        return mqttPahoMessageHandler;
    }
}
