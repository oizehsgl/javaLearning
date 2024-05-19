package org.oizehsgl.starter.demo.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.demo.service.DemoService;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@SpringBootTest
class StarterDemoServiceTest {
    @Resource
    private StarterDemoService starterDemoService;
    @Resource
    private DemoService demoService;

    @Test
    void demo() {
        demoService.demo();
        starterDemoService.demo();
    }
}