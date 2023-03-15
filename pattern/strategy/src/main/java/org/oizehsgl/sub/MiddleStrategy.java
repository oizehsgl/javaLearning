package org.oizehsgl.sub;

/**
 * middleStrategy
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class MiddleStrategy implements Strategy {
    @Override
    public void execute() {
        System.out.println(this.getClass().getSimpleName());
    }
}
