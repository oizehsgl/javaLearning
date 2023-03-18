package org.oizehsgl.sub;

/**
 * state
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public abstract class AbstractState implements State {
    Context context;

    public AbstractState(Context context) {
        this.context = context;
    }

}
