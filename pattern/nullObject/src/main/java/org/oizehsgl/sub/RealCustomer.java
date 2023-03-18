package org.oizehsgl.sub;

/**
 * realCustomer
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class RealCustomer extends AbstractCustomer{

    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isNil() {
        return false;
    }
}
