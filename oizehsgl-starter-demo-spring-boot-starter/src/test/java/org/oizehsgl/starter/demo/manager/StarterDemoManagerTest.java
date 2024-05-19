package org.oizehsgl.starter.demo.manager;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 */
@SpringBootTest
class StarterDemoManagerTest {
    @Resource
    private StarterDemoManager starterDemoManager;

    @Test
    void demo() {
        starterDemoManager.demo();
    }
}