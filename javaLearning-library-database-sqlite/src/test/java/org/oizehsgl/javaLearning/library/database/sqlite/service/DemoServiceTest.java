package org.oizehsgl.javaLearning.library.database.sqlite.service;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.oizehsgl.javaLearning.library.database.sqlite.entity.DemoEntity;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author oizehsgl
 */
@SpringBootTest
class DemoServiceTest {
    @Resource
    private DemoService demoService;

    @Test
    public void test() {
        DemoEntity demoEntity = DemoEntity.builder().name("testName").build();
        demoService.save(demoEntity);
        List<DemoEntity> demoEntityList = demoService.list();
        System.out.println(demoEntityList);
    }
}