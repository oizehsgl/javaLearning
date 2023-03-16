package org.oizehsgl.sub;

/**
 * shapeAbstract
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public abstract class ShapeAbstract {
    protected ColorImplementor colorImplementor;
    protected SizeImplementor sizeImplementor;

    public void setColorImplementor(ColorImplementor colorImplementor) {
        this.colorImplementor = colorImplementor;
    }

    public void setSizeImplementor(SizeImplementor sizeImplementor) {
        this.sizeImplementor = sizeImplementor;
    }

    void draw() {
        System.out.printf("size:<%s> color<%s> shape:<%s>%n", sizeImplementor, colorImplementor, this);
    }
}
