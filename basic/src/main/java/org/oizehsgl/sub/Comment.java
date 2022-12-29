package org.oizehsgl.sub;

/**
 * 注释
 *
 * @author oizehsgl
 * @since 2022/12/28
 */
public class Comment {
    public static void main(String[] args) { // main start
        System.out.println("注释");
        System.out.printf("%s: %s%n", "单行", "//");
        System.out.printf("%s: %s%n", "多行", "\n/*\n*\n*/");
        System.out.printf("%s: %s%n", "文档行", "\n/**\n*\n*/");
    }
}
