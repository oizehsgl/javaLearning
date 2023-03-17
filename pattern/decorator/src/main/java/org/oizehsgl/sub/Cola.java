package org.oizehsgl.sub;

/**
 * cola
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class Cola extends Drink {
    public Cola() {
        name=this.getClass().getSimpleName();
    }

    @Override
    public Integer cost() {
        return 100;
    }
}
