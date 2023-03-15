package org.oizehsgl.sub;

/**
 * context
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class Context implements Strategy {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void execute() {
        strategy.execute();
    }
}
