package org.oizehsgl.sub;

import org.junit.Test;

/**
 * stateTest
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class AbstractStateTest {
    @Test
    public void testState() {

        Context context = new Context();

        context.doAction();
        context.doAction();
        context.doAction();
        context.doAction();
    }
}