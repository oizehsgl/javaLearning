package org.oizehsgl.sub;

/**
 * alphaGreekLetter
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class AlphaGreekLetter implements GreekLetter {

    @Override
    public GreekLetter successor() {
        return new BetaGreekLetter();
    }
}
