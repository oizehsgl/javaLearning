package org.oizehsgl.sub;


import java.util.Random;

/**
 * volatile
 *
 * @author oizehsgl
 * @since 3/6/23
 */
public class Volatile {
    /**
     * 添加volatile后可避免指令重排
     */
    /*volatile*/ static int a = 0, b = 0;
    volatile static int x = 0, y = 0;

    /**
     * 复现指令重排
     *
     * @return sum
     * @throws InterruptedException 中断异常
     */
    public int reordering() throws InterruptedException {
        a = 0;
        b = 0;
        x = 0;
        y = 0;
        Thread one = new Thread(() -> {
            nanoWait(new Random().nextInt(50));
            a = 1;
            x = b;
        });

        Thread two = new Thread(() -> {
            nanoWait(new Random().nextInt(50));
            b = 1;
            y = a;
        });
        one.start();
        two.start();
        one.join();
        two.join();
        return x + y;
    }

    /**
     * 纳秒等待
     *
     * @param nanoInterval 间隔
     */
    public static void nanoWait(long nanoInterval) {
        long begin = System.nanoTime();
        long now = System.nanoTime();
        while (now - begin < nanoInterval) {
            now = System.nanoTime();
        }
    }
}
