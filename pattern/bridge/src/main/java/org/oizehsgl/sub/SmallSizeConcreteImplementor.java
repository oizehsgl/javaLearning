package org.oizehsgl.sub;

/**
 * smallSizeConcreteImplementor
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class SmallSizeConcreteImplementor implements SizeImplementor{
    @Override
    public SizeImplementor draw() {
        return this;
    }
}
