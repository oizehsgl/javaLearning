package org.oizehsgl.sub;

/**
 * arabNumberAdapterGreekLetter
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class ArabNumberAdapterGreekLetter implements ArabNumber {
    private GreekLetter greekLetter;

    public ArabNumberAdapterGreekLetter(GreekLetter greekLetter) {
        this.greekLetter = greekLetter;
    }

    @Override
    public String successor() {
        return greekLetter.successor().toString();
    }
}
