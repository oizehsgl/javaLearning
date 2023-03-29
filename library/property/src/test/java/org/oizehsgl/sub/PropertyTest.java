package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * propertyTest
 *
 * @author oizehsgl
 * @since 3/20/23
 */
@SpringBootTest
public class PropertyTest {
    @Autowired
    private Property property;

    @Test
    public void testProperty() {
        System.out.println(property);
        System.out.println(SubProperty.STATIC_STRING);
    }
}
