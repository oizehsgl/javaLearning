package org.oizehsgl.sub;

/**
 * successor
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class Successor implements Operation {
    @Override
    public void successor(ArabNumber arabNumber) {
        System.out.println(arabNumber.successor());
    }
}
