package org.oizehsgl.sub;

/**
 * demoProduct
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class DemoProduct {
    private DemoShape demoShape;
    private DemoColor demoColor;

    public DemoShape getDemoShape() {
        return demoShape;
    }

    public void setDemoShape(DemoShape demoShape) {
        this.demoShape = demoShape;
    }

    public DemoColor getDemoColor() {
        return demoColor;
    }

    public void setDemoColor(DemoColor demoColor) {
        this.demoColor = demoColor;
    }

    @Override
    public String toString() {
        return "DemoProduct{" +
                "demoShape=" + demoShape +
                ", demoColor=" + demoColor +
                '}';
    }
}
