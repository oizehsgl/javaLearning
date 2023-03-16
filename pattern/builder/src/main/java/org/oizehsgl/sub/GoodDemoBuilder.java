package org.oizehsgl.sub;

/**
 * goodDemoBuilder
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class GoodDemoBuilder extends DemoBuilder {
    @Override
    public void choiceShape() {
        demoProduct.setDemoShape(new GoodDemoShape());
    }

    @Override
    public void choiceColor() {
        demoProduct.setDemoColor(new GoodDemoColor());
    }
}
