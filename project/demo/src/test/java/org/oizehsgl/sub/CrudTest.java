package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.example.entity.SimpleDemo;
import org.oizehsgl.sub.example.service.SimpleDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalTime;

/**
 * crudTest
 *
 * @author oizehsgl
 * @since 4/9/23
 */
@SpringBootTest
public class CrudTest {
    @Autowired
    private SimpleDemoService simpleDemoService;

    @Test
    public void testCreate() {
        simpleDemoService.save(SimpleDemo.builder().age(1).build());
        simpleDemoService.list(null).stream().forEach(System.out::println);
        simpleDemoService.lambdaUpdate().eq(SimpleDemo::getAge, 1).set(SimpleDemo::getName, LocalTime.now()).update(SimpleDemo.builder().build());
        simpleDemoService.lambdaUpdate().ne(SimpleDemo::getId,1).remove();
        simpleDemoService.save(SimpleDemo.builder().age(1).build());
    }
}
