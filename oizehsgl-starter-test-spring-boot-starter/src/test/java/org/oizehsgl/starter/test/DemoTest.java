package org.oizehsgl.starter.test;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.demo.service.DemoService;
import org.oizehsgl.starter.demo.manager.StarterDemoManager;
import org.oizehsgl.starter.demo.service.StarterDemoService;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@SpringBootTest
public class DemoTest {
    @Resource
    private StarterDemoService starterDemoService;
    @Resource
    private StarterDemoManager starterDemoManager;
    @Resource
    private DemoService demoService;

    @Test
    void test(){
        demoService.demo();
        starterDemoService.demo();
        starterDemoManager.demo();
    }
}
