package org.oizehsgl.demo.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author oizehsgl
 */
@SpringBootTest
class DemoServiceTest {
    @Resource
    private DemoService demoService;

    @Test
    void demo() {
        demoService.demo();
    }
}