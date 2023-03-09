package org.oizehsgl.sub;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 原子单例
 *
 * @author oizehsgl
 * @since 3/9/23
 */
public class AtomicReferanceSingleton {
    /**
     * 私有构造
     */
    private AtomicReferanceSingleton() {
    }

    /**
     * 静态对象
     * AtomicReference 提供了可以原子的读写对象引用的一种机制
     */
    private static final AtomicReference<AtomicReferanceSingleton> INSTANCE = new AtomicReference<AtomicReferanceSingleton>();

    /**
     * 获取单例
     *
     * @return 单例
     */
    public static AtomicReferanceSingleton getInstance() {
        for (; ; ) {
            // 从 INSTANCE中 获取实例
            AtomicReferanceSingleton singleton = INSTANCE.get();
            // 如果实例不为空就返回
            if (null != singleton) {
                return singleton;
            }
            // 实例为空就创建实例
            singleton = new AtomicReferanceSingleton();
            // compareAndSet() 主要的作用是通过比对两个对象，然后更新为新的对象
            if (INSTANCE.compareAndSet(null, singleton)) {
                return singleton;
            }
        }
    }
}
