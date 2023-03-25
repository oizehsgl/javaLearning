package org.oizehsgl.sub;

/**
 * subDemo
 *
 * @author oizehsgl
 * @since 3/25/23
 */
public class SupDemo {
    public SupDemo(int i) {
        print(i);
    }

    public int p1 = print(1);
    public final int p2 = print(2);
    public static int ps1 = print(-1);
    public static final int ps2 = print(-2);

    {
        print(3);
    }

    public static SupDemo subDemo = new SupDemo(-3);

    static {
        print(-4);
    }

    public static final int ps5 = print(-5);
    public final int p4 = print(4);

    public static int print(int i) {
        System.out.printf("%2d ps1=%2d ps2=%2d ps5=%2d%n", i,ps1,ps2,ps5);
        return i;
    }
}
