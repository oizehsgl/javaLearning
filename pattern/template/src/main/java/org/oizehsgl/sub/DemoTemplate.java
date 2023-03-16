package org.oizehsgl.sub;

/**
 * demoTemplate
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public abstract class DemoTemplate {
    protected abstract void first();

    protected void second() {
    }

    protected abstract void third();

    public final void start() {
        first();
        second();
        third();
    }
}
