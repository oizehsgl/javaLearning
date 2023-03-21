package org.oizehsgl.sub;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;

/**
 * mqttConfig
 *
 * @author oizehsgl
 * @since 3/21/23
 */
@Slf4j
//@Configuration
public class MqttConfig {
    /**
     * 订阅的bean名称
     */
    public static final String CHANNEL_NAME_IN = "mqttInboundChannel";
    /**
     * 发布的bean名称
     */
    public static final String CHANNEL_NAME_OUT = "mqttOutboundChannel";

    @Autowired
    private MqttProducerProperties mqttProducerProperties;

    /**
     * mqtt连接选项
     *
     * @return {@link org.eclipse.paho.client.mqttv3.MqttConnectOptions}
     */
    @Bean
    public MqttConnectOptions getMqttConnectOptions() {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        // 设置是否清空session，
        mqttConnectOptions.setCleanSession(true);
        // 设置连接的用户名
        mqttConnectOptions.setUserName(mqttProducerProperties.getUsername());
        // 设置连接的密码
        mqttConnectOptions.setPassword(mqttProducerProperties.getPassword().toCharArray());
        // 设置url
        mqttConnectOptions.setServerURIs(new String[]{mqttProducerProperties.getUrl()});
        // 设置超时时间 单位为秒
        mqttConnectOptions.setConnectionTimeout(mqttProducerProperties.getTimeout());
        // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送心跳判断客户端是否在线，但这个方法并没有重连的机制
        mqttConnectOptions.setKeepAliveInterval(mqttProducerProperties.getKeepAlive());
        // 设置“遗嘱”消息的话题，若客户端与服务器之间的连接意外中断，服务器将发布客户端的“遗嘱”消息。
        mqttConnectOptions.setWill("willTopic", "offline".getBytes(), 2, false);
        return mqttConnectOptions;
    }

    /**
     * mqtt客户工厂
     *
     * @return {@link org.springframework.integration.mqtt.core.MqttPahoClientFactory}
     */
    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory defaultMqttPahoClientFactory = new DefaultMqttPahoClientFactory();
        defaultMqttPahoClientFactory.setConnectionOptions(getMqttConnectOptions());
        return defaultMqttPahoClientFactory;
    }
}
