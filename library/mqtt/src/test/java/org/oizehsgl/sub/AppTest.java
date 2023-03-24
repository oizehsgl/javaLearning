package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class AppTest {

    @Autowired
    private MqttController mqttController;
//    @Autowired
    private MqttTopicEnum mqttTopicEnum;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testApp() {
        Assert.isTrue(true);
        System.out.println(mqttController);
        System.out.println(MqttTopicEnum.values());
        for (MqttTopicEnum value : MqttTopicEnum.values()) {
            System.out.println(value);
        }
    }
}
