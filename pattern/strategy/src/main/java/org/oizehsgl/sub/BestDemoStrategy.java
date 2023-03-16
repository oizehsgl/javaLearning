package org.oizehsgl.sub;

/**
 * bestDemoStrategy
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class BestDemoStrategy implements DemoStrategy {
    @Override
    public void execute() {
        System.out.println(this.getClass().getSimpleName());
    }
}
