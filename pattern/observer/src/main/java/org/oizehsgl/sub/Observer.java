package org.oizehsgl.sub;

/**
 * observer
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}
