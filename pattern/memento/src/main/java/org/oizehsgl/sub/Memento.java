package org.oizehsgl.sub;

/**
 * memento
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class Memento {

    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}