package org.oizehsgl.sub;

/**
 * abstractFactory
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public abstract class AbstractFactory {
    public abstract Greek getGreek(String className);

    public abstract Arab getArab(String className);
}
