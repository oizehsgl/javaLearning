package org.oizehsgl.sub;

import java.io.Serializable;

/**
 * 静态内部类单例
 *
 * @author oizehsgl
 * @since 3/9/23
 */
public class StaticInnerSingleton implements Serializable {
    /**
     * 私有构造
     */
    private StaticInnerSingleton() {
        // 防止反射创建多个对象
        if (SingletonHolder.instance != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    /**
     * 静态对象
     */
    private static class SingletonHolder {
        private static final StaticInnerSingleton instance = new StaticInnerSingleton();
    }

    /**
     * 获取单例
     * 通过静态内部类获取单例对象, 没有加锁, 线程安全, 并发性能高
     *
     * @return 单例
     */
    public static StaticInnerSingleton getInstance() {
        return SingletonHolder.instance;
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
