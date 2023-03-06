package org.oizehsgl.sub;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testApp() {
        System.out.printf("%s: %s%n", "包", "package xx.xx.xx;");
        System.out.printf("%s: %s%n", "导入", "import xx.xx.xx;");
        System.out.printf("%s: %s%n", "外部类", "外部类类访问修饰符{public,default} 类修饰符{default,abstract,final} 类型{class,enum,interface,@interface} 大驼峰 {...}");
        System.out.printf("%s: %s%n", "内部类", "内部类访问修饰符{public,default,protected,public} 类修饰符{default,abstract,final} 类型{class,enum,interface,@interface} 大驼峰 {...}");
        System.out.printf("%s: %s%n", "成员变量", "成员变量访问修饰符{public,default,protected,public} 类修饰符{default,abstract,final,transient,volatile} 类型{,,,} 小驼峰 [=]{,,,};");
        System.out.printf("%s: %s%n", "方法", "方法访问修饰符{public,default,protected,public} 类修饰符{default,abstract,final,synchronize,native} 类型{,,,} 小驼峰 {...}");
        System.out.printf("变量: %-20s 位置: %-20s 存储: %-20s 周期: %-20s\n", "成员变量","类中{}","堆","同实例");
        System.out.printf("变量: %-20s 位置: %-20s 存储: %-20s 周期: %-20s\n", "局部变量","方法中{{}}","栈","同方法");
        System.out.printf("变量: %-20s 位置: %-20s 存储: %-20s 周期: %-20s\n", "静态变量","类中{}","方法区","同类");
    }
}
