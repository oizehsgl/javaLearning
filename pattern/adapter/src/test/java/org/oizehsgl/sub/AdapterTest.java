package org.oizehsgl.sub;

import org.junit.Test;

/**
 * adapterTest
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class AdapterTest {
    @Test
    public void testAdapter() {
        Successor successor = new Successor();
        ArabNumber arabNumber = new OneArabNumber();
        successor.successor(arabNumber);
        ArabNumber arabNumberAdapterGreekLetter =new ArabNumberAdapterGreekLetter(new AlphaGreekLetter());
        successor.successor(arabNumberAdapterGreekLetter);
    }
}
