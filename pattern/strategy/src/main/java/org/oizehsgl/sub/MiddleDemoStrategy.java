package org.oizehsgl.sub;

/**
 * middleDemoStrategy
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class MiddleDemoStrategy implements DemoStrategy {
    @Override
    public void execute() {
        System.out.println(this.getClass().getSimpleName());
    }
}
