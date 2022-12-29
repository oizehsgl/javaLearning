package org.oizehsgl.sub;

import java.time.LocalDate;

/**
 * 体系
 *
 * @author oizehsgl
 * @since 2022/12/28
 */
public class Architecture {
    public static void main(String[] args) {
        System.out.println(LocalDate.now());
        System.out.printf("%s: %s%n", "包", "package xx.xx.xx;");
        System.out.printf("%s: %s%n", "导入", "import xx.xx.xx;");
        System.out.printf("%s: %s%n", "外部类", "外部类类访问修饰符{public,default} 类修饰符{default,abstract,final} 类型{class,enum,interface,@interface} 大驼峰 {...}");
        System.out.printf("%s: %s%n", "内部类", "内部类访问修饰符{public,default,protected,public} 类修饰符{default,abstract,final} 类型{class,enum,interface,@interface} 大驼峰 {...}");
        System.out.printf("%s: %s%n", "成员变量", "成员变量访问修饰符{public,default,protected,public} 类修饰符{default,abstract,final,transient,volatile} 类型{,,,} 小驼峰 [=]{,,,};");
        System.out.printf("%s: %s%n", "方法", "方法访问修饰符{public,default,protected,public} 类修饰符{default,abstract,final,synchronize,native} 类型{,,,} 小驼峰 {...}");
    }
}
