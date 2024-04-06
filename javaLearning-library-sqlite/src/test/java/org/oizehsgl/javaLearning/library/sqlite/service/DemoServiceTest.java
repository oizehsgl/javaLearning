package org.oizehsgl.javaLearning.library.sqlite.service;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.javaLearning.library.sqlite.Po.DemoPo;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author yueyuanzhi
 */
@SpringBootTest
class DemoServiceTest {
    @Resource
    private DemoService demoService;

    @Test
    public void test() {
        DemoPo demoPo = DemoPo.builder().name("testName").build();
        demoService.save(demoPo);
        List<DemoPo> demoPoList = demoService.list();
        System.out.println(demoPoList);
    }
}