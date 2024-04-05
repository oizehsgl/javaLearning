package org.oizehsgl.javaLearning.library.mqtt.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yueyuanzhi
 */
@SpringBootTest
class MqttServiceTest {
    @Resource
    private MqttService mqttService;

    @Test
    @Disabled("不太方便自动测试")
    void testSend() {
        mqttService.send("testSendPayload");
    }
}