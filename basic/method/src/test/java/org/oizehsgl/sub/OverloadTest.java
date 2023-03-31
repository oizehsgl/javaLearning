package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * overloadTest
 *
 * @author oizehsgl
 * @since 3/31/23
 */
public class OverloadTest {
    private <T> void test(Supplier<T> supplier) {
        System.out.println("supplier");
    }

    private <T> void test(Consumer<T> consumer) {
        System.out.println("consumer");
    }

    private <T, R> void test(Function<T, R> function) {
        System.out.println("function");
    }

    private void test(Runnable runnable) {
        System.out.println("runnable");
    }

    private <T> String fun(T t) {
        return null;
    }

    private String fun(String s) {
        return null;
    }

    public void fun(Integer i) {
    }

    private void fun() {
    }
//    private String fun() {return null;}


    @Test
    public void testOverload() {
        // 根据i类型判定fun类型
        Stream.of(1, 2, 3).forEach(i -> fun(i));
        Stream.of("1", "2", "3").forEach(i -> fun(i));
        // 没有i类型不知道fun是哪一个,但是根据块可以推断void-compatible或者value-compatible
        test(i -> {
            fun(i);
        });
        test(i -> {
            return fun(i);
        });
        // i类型-->决定fun-->fun返回类型-->决定test
        test((Object i) -> fun(i));
        test((Integer i) -> fun(i));
        test((String i) -> fun(i));
        test(() -> fun());
        /**
         * https://docs.oracle.com/javase/specs/jls/se8/html/jls-15.html#jls-15.12.2
         *
         * The second step searches the type determined in the previous step for member methods. This step uses the name of the method and the argument expressions to locate methods that are both accessible and applicable, that is, declarations that can be correctly invoked on the given arguments.
         * There may be more than one such method, in which case the most specific one is chosen. The descriptor (signature plus return type) of the most specific method is the one used at run time to perform the method dispatch.
         * A method is applicable if it is applicable by one of strict invocation (§15.12.2.2), loose invocation (§15.12.2.3), or variable arity invocation (§15.12.2.4).
         * Certain argument expressions that contain implicitly typed lambda expressions (§15.27.1) or inexact method references (§15.13.1) are ignored by the applicability tests, because their meaning cannot be determined until a target type is selected.
         * Although the method invocation may be a poly expression, only its argument expressions - not the invocation's target type - influence the selection of applicable methods.
         * The process of determining applicability begins by determining the potentially applicable methods (§15.12.2.1).
         *
         * 第二步在上一步确定的类型中搜索成员方法。此步骤使用方法的名称和参数表达式来定位既可访问又适用的方法，即可以在给定参数上正确调用的声明。
         * 可能有不止一种这样的方法，在这种情况下，选择最具体的一种。最具体方法的描述符（签名加上返回类型）是在运行时用于执行方法分派的描述符。
         * 如果方法适用于严格调用（第 15.12.2.2 节）、松散调用（第 15.12.2.3 节）或可变元数调用（第 15.12.2.4 节）之一，则该方法适用
         * 某些包含隐式类型的 lambda 表达式 (§15.27.1) 或不精确的方法引用 (§15.13.1) 的参数表达式将被适用性测试忽略，因为在选择目标类型之前无法确定它们的含义。
         * 尽管方法调用可能是一个 poly 表达式，但只有它的参数表达式——而不是调用的目标类型——会影响适用方法的选择。
         * 确定适用性的过程首先确定可能适用的方法 (§15.12.2.1)。
         */
        // 不能根据i类型来决定fun()类型,所以test方法不能确定
        // 所以箭头函数i->fun()的参数列表不是()而是i,fun()只是方法调用
        // 决定方法不是先看是否有冲突方法再看参数列表，而是用参数列表再去看是否有冲突方法
        //test(i -> fun(i));
        //test(i -> fun());
    }

}
