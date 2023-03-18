package org.oizehsgl.sub;

/**
 * customerFactory
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class CustomerFactory {
    public static final String[] names = {"Rob", "Joe", "Julie"};

    public static AbstractCustomer getCustomer(String name) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(name)) {
                return new RealCustomer(name);
            }
        }
        return new NilCustomer();
    }
}
