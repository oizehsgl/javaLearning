package org.oizehsgl.sub;

/**
 * 贪婪单例
 *
 * @author oizehsgl
 * @since 3/9/23
 */
public class HungrySingleton {

    /**
     * 私有构造
     */
    private HungrySingleton() {
        // 防止反射创建多个对象
        if (HungrySingleton.instance != null) {
            throw new RuntimeException("不允许创建多个实例");
        }
    }

    /**
     * 静态对象
     */
    private static final HungrySingleton instance = new HungrySingleton();

    /**
     * 获取单例
     *
     * @return instance 本类的实例
     */
    public static HungrySingleton getInstance() {
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
