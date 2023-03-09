package org.oizehsgl.sub;

/**
 * 本地线程单例
 *
 * @author oizehsgl
 * @since 3/9/23
 */
public class ThreadLocalSingleton {
    /**
     * 私有构造
     */
    private ThreadLocalSingleton() {
        // 防止反射创建多个对象
        if (singleton != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    /**
     * 静态对象
     */
    private static final ThreadLocal<ThreadLocalSingleton> singleton = ThreadLocal.withInitial(() -> new ThreadLocalSingleton());

    /**
     * 获取单例
     *
     * @return 单例
     */
    public static ThreadLocalSingleton getInstance() {
        return singleton.get();
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
