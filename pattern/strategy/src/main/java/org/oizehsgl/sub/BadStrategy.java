package org.oizehsgl.sub;

/**
 * badStrategy
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class BadStrategy implements Strategy {
    @Override
    public void execute() {
        System.out.println(this.getClass().getSimpleName());
    }
}
