package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.oizehsgl.sub.annotation.DemoLogSubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

/**
 * annotationTest
 *
 * @author oizehsgl
 * @since 4/10/23
 */
@SpringBootTest
public class AnnotationTest {
    @Autowired
    private DemoLogSubService demoLogSubService;

    @Test
    public void testAnnotation() {
        demoLogSubService.method1(Arrays.asList(1), "1");
        demoLogSubService.method2(Arrays.asList(2), "2");
        demoLogSubService.method3(Arrays.asList(3), "3");
        demoLogSubService.method4(Arrays.asList(4), "4");
        demoLogSubService.method5(Arrays.asList(5), "5");
    }
}
