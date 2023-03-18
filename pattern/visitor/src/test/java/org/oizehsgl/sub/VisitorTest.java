package org.oizehsgl.sub;

import org.junit.Test;

/**
 * visitorTest
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class VisitorTest {
    @Test
    public void testVisitor() {
        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor());
    }
}
