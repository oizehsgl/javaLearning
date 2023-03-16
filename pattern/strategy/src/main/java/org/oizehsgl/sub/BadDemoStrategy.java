package org.oizehsgl.sub;

/**
 * badDemoStrategy
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class BadDemoStrategy implements DemoStrategy {
    @Override
    public void execute() {
        System.out.println(this.getClass().getSimpleName());
    }
}
