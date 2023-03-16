package org.oizehsgl.sub;

/**
 * oneArabNumber
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class OneArabNumber implements ArabNumber {
    @Override
    public String successor() {
        return new TwoArabNumber().toString();
    }
}
