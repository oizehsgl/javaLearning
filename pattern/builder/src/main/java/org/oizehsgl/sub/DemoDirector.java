package org.oizehsgl.sub;

/**
 * demoDirector
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class DemoDirector {
    private DemoBuilder demoBuilder;

    public void setDemoBuilder(DemoBuilder demoBuilder) {
        this.demoBuilder = demoBuilder;
    }

    public void construct() {
        demoBuilder.choiceShape();
        demoBuilder.choiceColor();
    }
}
