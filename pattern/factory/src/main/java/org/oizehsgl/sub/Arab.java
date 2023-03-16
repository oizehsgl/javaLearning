package org.oizehsgl.sub;

/**
 * arab
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public abstract class Arab extends Brand {
    void write() {
        System.out.printf("%s: %s%n", getBrand(), this.getClass().getSimpleName());
    }
}
