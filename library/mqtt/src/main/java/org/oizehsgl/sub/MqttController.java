package org.oizehsgl.sub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * mqttController
 *
 * @author oizehsgl
 * @since 3/21/23
 */
@RestController
public class MqttController {
    @Autowired
    private MqttGateway mqttGateway;

    /**
     * 发送MQTT消息
     *
     * @param message 消息内容
     * @return 返回数据
     */
    @ResponseBody
    @GetMapping(value = "/mqtt/{msg}")
    public ResponseEntity<String> sendMqtt(@PathVariable(name = "msg") String message) {
        mqttGateway.send("/defaultTopic", 1, message);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
