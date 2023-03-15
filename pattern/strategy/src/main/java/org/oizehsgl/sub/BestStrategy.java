package org.oizehsgl.sub;

/**
 * bestStrategy
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class BestStrategy implements Strategy {
    @Override
    public void execute() {
        System.out.println(this.getClass().getSimpleName());
    }
}
