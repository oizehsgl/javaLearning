package org.oizehsgl.sub;

/**
 * demoContext
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class DemoContext implements DemoStrategy {
    private DemoStrategy demoStrategy;

    public void setStrategy(DemoStrategy demoStrategy) {
        this.demoStrategy = demoStrategy;
    }

    @Override
    public void execute() {
        demoStrategy.execute();
    }
}
