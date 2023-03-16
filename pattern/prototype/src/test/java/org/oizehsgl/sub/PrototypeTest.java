package org.oizehsgl.sub;

import org.junit.Test;

/**
 * prototypeTest
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class PrototypeTest {
    @Test
    public void testPrototype() {
        DemoCache.loadCache();
        for (int i = 0; i < 2; i++) {
            DemoPrototype demoPrototype1 = DemoCache.getDemoPrototype(1);
            demoPrototype1.write();
            DemoPrototype demoPrototype2 = DemoCache.getDemoPrototype(2);
            demoPrototype2.write();
        }
    }
}
