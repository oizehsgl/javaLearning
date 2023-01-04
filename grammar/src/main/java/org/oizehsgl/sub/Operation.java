package org.oizehsgl.sub;

/**
 * 运算
 *
 * @author oizehsgl
 * @since 2023/1/3
 */
public class Operation {
    public static void main(String[] args) {
        System.out.printf("%s\n", "复合运算");
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "小括号","()",1);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "中括号","[]",1);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "点",".",1);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "逗号",",",-15);
        System.out.printf("%s\n", "强转运算");
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "强转","(xx)",1);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "类型","instanceof",6);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "三目","b?t:f",13);
        System.out.printf("%s\n", "一元运算");
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "反","!",-2);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "非","~",-2);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "增","++",-2);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "减","--",-2);
        System.out.printf("%s\n", "整数运算");
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "乘","*",3);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "除","/",3);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "余","%",3);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "加","+",4);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "减","-",4);
        System.out.printf("%s\n", "位运算");
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "左","<<",5);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "右",">>",5);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "无符号右移",">>>",5);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "与","&",8);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "或","|",10);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "异或","^",9);
        System.out.printf("%s\n", "赋值运算");
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "x赋值","x=",-14);
        System.out.printf("%s\n", "比较运算");
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "大于",">",6);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "大于等于",">=",6);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "小于","<",6);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "小于等于","<=",6);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "等于","==",7);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "不等于","!=",7);
        System.out.printf("%s\n", "逻辑运算");
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "与","&&",11);
        System.out.printf("类型: %s 符号: %s 优先级: %d\n", "或","||",12);
    }
}
