package org.oizehsgl.sub;

import org.junit.Test;

/**
 * compositeTest
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class CompositeTest {
    @Test
    public void testComposite() {
        DemoComposite demo1 = new DemoComposite(1);
        AlphaDemoComponent demo11 = new AlphaDemoComponent(11);
        BetaDemoComponent demo12 = new BetaDemoComponent(12);
        demo1.add(demo11);
        demo1.add(demo12);
        DemoComposite demo2 = new DemoComposite(2);
        AlphaDemoComponent demo21 = new AlphaDemoComponent(21);
        BetaDemoComponent demo22 = new BetaDemoComponent(22);
        demo2.add(demo21);
        demo2.add(demo22);
        demo1.add(demo2);
        System.out.println("demo1.getLevel() = " + demo1.getLevel());
        System.out.println("demo1.getCount() = " + demo1.getCount());
    }
}
