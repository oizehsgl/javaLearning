package org.oizehsgl.sub;

/**
 * betaDemoPrototype
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class BetaDemoPrototype extends DemoPrototype {
    public BetaDemoPrototype() {
        value = this.getClass().getSimpleName();
    }

    @Override
    void write() {
        System.out.printf("%s: %s%n",value,this);
    }
}
