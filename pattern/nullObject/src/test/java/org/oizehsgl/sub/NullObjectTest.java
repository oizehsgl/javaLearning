package org.oizehsgl.sub;

import org.junit.Test;

/**
 * nullObjectTest
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class NullObjectTest {
    @Test
    public void testNullObject() {

        AbstractCustomer customer1 = CustomerFactory.getCustomer("Rob");
        AbstractCustomer customer2 = CustomerFactory.getCustomer("Bob");
        AbstractCustomer customer3 = CustomerFactory.getCustomer("Julie");
        AbstractCustomer customer4 = CustomerFactory.getCustomer("Laura");

        System.out.println("Customers");
        System.out.println(customer1.getName());
        System.out.println(customer2.getName());
        System.out.println(customer3.getName());
        System.out.println(customer4.getName());
    }
}
