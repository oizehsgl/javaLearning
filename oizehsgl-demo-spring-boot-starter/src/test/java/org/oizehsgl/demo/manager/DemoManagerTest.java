package org.oizehsgl.demo.manager;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author oizehsgl
 */
@SpringBootTest
class DemoManagerTest {
    @Resource
    private DemoManager demoManager;

    @Test
    void demo() {
        demoManager.demo();
    }
}