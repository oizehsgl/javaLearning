package org.oizehsgl.sub;

/**
 * subDemo
 *
 * @author oizehsgl
 * @since 3/25/23
 */
public class SubDemo extends SupDemo{
    public SubDemo(int i) {
        super(i);
        print(i);
    }

    public int b1 = print(1);
    public final int b2 = print(2);
    public static int bs1 = print(-1);
    public static final int bs2 = print(-2);

    {
        print(3);
    }

    public static SubDemo subDemo = new SubDemo(-3);

    static {
        print(-4);
    }

    public static final int bs5 = print(-5);
    public final int b4 = print(4);

    public static int print(int i) {
        System.out.printf("%2d bs1=%2d bs2=%2d bs5=%2d%n", i,bs1,bs2,bs5);
        return i;
    }
}
