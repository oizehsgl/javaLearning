package org.oizehsgl.sub;

import org.junit.Test;

/**
 * strategyTest
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class StrategyTest {
    @Test
    public void test(){
        DemoContext demoContext = new DemoContext();
        demoContext.setStrategy(new BestDemoStrategy());
        demoContext.execute();
    }
}
