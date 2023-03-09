package org.oizehsgl.sub;

import java.util.ArrayList;
import java.util.List;

/**
 * 惰性单例
 *
 * @author oizehsgl
 * @since 3/9/23
 */
public class LazySingleton {
    /**
     * 私有构造
     */
    private LazySingleton() {
        // 防止反射创建多个对象
        if (LazySingleton.instance != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    /**
     * 静态对象
     */
    private static volatile LazySingleton instance;

    /**
     * 获取单例
     * 线程不安全, 可以在方法上使用synchronized关键字实现线程安全
     *
     * @return 单例
     */
    public static LazySingleton threadUnsafeGetInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 获取单例
     * 在获取实例的公共方法上使用synchronized关键字实现线程安全
     *
     * @return 单例
     */
    public synchronized static LazySingleton threadSafetyGetInstance() {
        List<Integer> list = new ArrayList<>();
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }

    /**
     * 获取单例
     *
     * @return 单例
     */
    public static LazySingleton getInstance() {
        // 先判断实例是否存在
        if (instance == null) {
            // 加锁创建实例
            synchronized (LazySingleton.class) {
                // 再次判断, 因为可能出现某个线程拿了锁之后, 还没来得及执行初始化就释放了锁,
                // 而此时其他的线程拿到了锁又执行到此处 ==> 这些线程都会创建一个实例, 从而创建多个实例对象
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    /**
     * 禁止序列
     *
     * @return 单例
     */
    private Object readResolve() {
        return getInstance();
    }
}
