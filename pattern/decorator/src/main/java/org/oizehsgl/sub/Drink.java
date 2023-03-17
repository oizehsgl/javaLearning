package org.oizehsgl.sub;

/**
 * drink
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public abstract class Drink {
    public String name;

    public abstract Integer cost();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
