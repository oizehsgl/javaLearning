package org.oizehsgl.sub;

/**
 * badDemoBuilder
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class BadDemoBuilder extends DemoBuilder {
    @Override
    public void choiceShape() {
        demoProduct.setDemoShape(new BadDemoShape());
    }

    @Override
    public void choiceColor() {
        demoProduct.setDemoColor(new BadDemoColor());
    }
}
