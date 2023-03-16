package org.oizehsgl.sub;

/**
 * alphaDemoTemplate
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class AlphaDemoTemplate extends DemoTemplate {
    @Override
    protected void first() {
        System.out.printf("%s: %s%n", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
    }

    @Override
    protected void third() {
        System.out.printf("%s: %s%n", this.getClass().getSimpleName(), Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
