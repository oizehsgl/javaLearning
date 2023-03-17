package org.oizehsgl.sub;

/**
 * stock
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class Stock {
    private String key = Stock.class.getSimpleName();
    private Integer value = 10;

    public void buy() {
        System.out.printf("%s: %s=%s%n", Thread.currentThread().getStackTrace()[1].getMethodName(), key, value);
    }

    public void sell() {
        System.out.printf("%s: %s=%s%n", Thread.currentThread().getStackTrace()[1].getMethodName(), key, value);
    }
}
