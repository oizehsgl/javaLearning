package org.oizehsgl.sub;

/**
 * ddr
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class Ddr implements ComputerAccessories {
    @Override
    public void open() {
        System.out.printf("%s %s%n", Thread.currentThread().getStackTrace()[1].getMethodName(), this.getClass().getSimpleName());
    }
    @Override
    public void close   () {
        System.out.printf("%s %s%n", Thread.currentThread().getStackTrace()[1].getMethodName(), this.getClass().getSimpleName());
    }
}
