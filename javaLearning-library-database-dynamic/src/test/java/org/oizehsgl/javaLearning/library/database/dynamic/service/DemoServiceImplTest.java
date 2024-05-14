package org.oizehsgl.javaLearning.library.database.dynamic.service;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author yueyuanzhi
 */
@SpringBootTest
class DemoServiceImplTest {
    @Resource
    private DemoService demoService;
    @Test
    public void test(){
        System.out.println(demoService.list());
    }
}