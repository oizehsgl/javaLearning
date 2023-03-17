package org.oizehsgl.sub;

import org.junit.Test;

/**
 * flyweightTest
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class FlyweightTest {
    @Test
    public void test() {
        Fly fly;
        for (int i = 0; i < 3; i++) {
            fly = FlyFactory.get(FlyFood.SHIT);
            fly.eat();
            fly = FlyFactory.get(FlyFood.FRUIT);
            fly.eat();
        }
    }
}
