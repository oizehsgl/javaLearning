package org.oizehsgl.sub;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

/**
 * mqttConsumerConfig
 *
 * @author oizehsgl
 * @since 3/22/23
 */
@Configuration
public class MqttConsumerConfig {
    @Autowired
    private MqttConsumerProperties mqttConsumerProperties;

    /**
     * mqtt连接选项
     *
     * @return {@link org.eclipse.paho.client.mqttv3.MqttConnectOptions}
     */
    public MqttConnectOptions getMqttConnectOptions() {
        MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
        // 设置是否清空session，
        mqttConnectOptions.setCleanSession(true);
        // 设置连接的用户名
        mqttConnectOptions.setUserName(mqttConsumerProperties.getUsername());
        // 设置连接的密码
        mqttConnectOptions.setPassword(mqttConsumerProperties.getPassword().toCharArray());
        // 设置url
        mqttConnectOptions.setServerURIs(new String[]{mqttConsumerProperties.getUrl()});
        // 设置超时时间 单位为秒
        mqttConnectOptions.setConnectionTimeout(mqttConsumerProperties.getTimeout());
        // 设置会话心跳时间 单位为秒 服务器会每隔1.5*20秒的时间向客户端发送心跳判断客户端是否在线，但这个方法并没有重连的机制
        mqttConnectOptions.setKeepAliveInterval(mqttConsumerProperties.getKeepAlive());
        // 设置“遗嘱”消息的话题，若客户端与服务器之间的连接意外中断，服务器将发布客户端的“遗嘱”消息。
        mqttConnectOptions.setWill("willTopic", "offline".getBytes(), 2, false);
        return mqttConnectOptions;
    }

    /**
     * mqtt信道
     *
     * @return {@link org.springframework.messaging.MessageChannel}
     */
    @Bean(name = MqttConstant.Channel.IN)
    public MessageChannel mqttInboundChannel() {
        return new DirectChannel();
    }

    /**
     * mqtt订阅绑定
     *
     * @return {@link org.springframework.integration.core.MessageProducer}
     */
    @Bean
    public MessageProducer inbound() {
        DefaultMqttPahoClientFactory defaultMqttPahoClientFactory = new DefaultMqttPahoClientFactory();
        defaultMqttPahoClientFactory.setConnectionOptions(getMqttConnectOptions());

        // 可以同时消费（订阅）多个Topic
        MqttPahoMessageDrivenChannelAdapter mqttPahoMessageDrivenChannelAdapter = new MqttPahoMessageDrivenChannelAdapter(
                mqttConsumerProperties.getClientId(),
                defaultMqttPahoClientFactory,
                mqttConsumerProperties.getTopics());
        // 设置完成超时时间
        //mqttPahoMessageDrivenChannelAdapter.setCompletionTimeout(30000);
        // 消息转换器
        DefaultPahoMessageConverter defaultPahoMessageConverter = new DefaultPahoMessageConverter();
        // 按字节接收消息
        //defaultPahoMessageConverter.setPayloadAsBytes(true);
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
     * @return {@link org.springframework.messaging.MessageHandler}
     */
    @Bean
    @ServiceActivator(inputChannel = MqttConstant.Channel.IN)
    public MessageHandler handler() {
        return message -> {
            // 收到的消息是字节格式
            // byte[] bytes = (byte[]) message.getPayload();
            String payload = message.getPayload().toString();
            String topic = message.getHeaders().get(MqttHeaders.RECEIVED_TOPIC).toString();

            //匹配.* 任意字符
            //设备上报主题/test/pub/ + 设备编号
            if (MqttTopic.isMatched("/defaultTopic", topic)) {
                System.out.println("负载为：" + payload);
            } else {
                System.out.println("丢弃消息：主题[" + topic + "]，负载：" + payload);
            }
        };
    }
}
