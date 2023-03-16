package org.oizehsgl.sub;

/**
 * demoBuilder
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public abstract class DemoBuilder {
    public DemoProduct demoProduct = new DemoProduct();

    public abstract void choiceShape();

    public abstract void choiceColor();

    public DemoProduct getProduct() {
        return demoProduct;
    }
}
