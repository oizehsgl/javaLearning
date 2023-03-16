package org.oizehsgl.sub;

import org.junit.Test;

/**
 * bridgeTest
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class BridgeTest {
    @Test
    public void testBridge() {
        ShapeAbstract shapeAbstract = new CircleShapeRefinedAbstraction();
        shapeAbstract.draw();
        shapeAbstract.setColorImplementor(new RedColorConcreteImplementor());
        shapeAbstract.draw();
        shapeAbstract.setSizeImplementor(new BigSizeConcreteImplementor());
        shapeAbstract.draw();
    }
}
