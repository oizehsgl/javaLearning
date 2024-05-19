package org.oizehsgl.starter.test;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.demo.manager.DemoManager;
import org.oizehsgl.demo.service.DemoService;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@SpringBootTest
public class DemoTest {
    @Resource
    private DemoService demoService;
    @Resource
    private DemoManager demoManager;

    @Test
    void test(){
        demoService.demo();
        demoManager.demo();
    }
}
