package org.oizehsgl.sub;

/**
 * alphaDemoPrototype
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class AlphaDemoPrototype extends DemoPrototype {
    public AlphaDemoPrototype() {
        value = this.getClass().getSimpleName();
    }

    @Override
    void write() {
        System.out.printf("%s: %s%n",value,this);
    }
}
