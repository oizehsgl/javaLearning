package org.oizehsgl.sub;

import org.junit.Test;

/**
 * builderTest
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class BuilderTest {
    @Test
    public void testBuilder() {
        DemoBuilder demoBuilder = new GoodDemoBuilder();
        DemoDirector demoDirector = new DemoDirector();
        demoDirector.setDemoBuilder(demoBuilder);
        demoDirector.construct();
        DemoProduct demoProduct = demoBuilder.getProduct();
        System.out.println(demoProduct);
    }
}
