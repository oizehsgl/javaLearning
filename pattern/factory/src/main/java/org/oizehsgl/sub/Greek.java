package org.oizehsgl.sub;

/**
 * greek
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public abstract class Greek extends Brand {
    void write() {
        System.out.printf("%s: %s%n", getBrand(), this.getClass().getSimpleName());
    }
}
