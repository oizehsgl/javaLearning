package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * propertyTest
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@SpringBootTest
public class PropertyTest {
    @Resource
    private Property property;

    @Test
    public void testProperty() {
        System.out.println(property);
        System.out.println(SubProperty.STATIC_STRING);
    }
}
