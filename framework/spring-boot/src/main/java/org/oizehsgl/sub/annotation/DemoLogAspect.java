package org.oizehsgl.sub.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.SourceLocation;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * demoLogAspect
 *
 * @author oizehsgl
 * @since 4/10/23
 */
@Slf4j
@Aspect
@Order(0)
@Component
public class DemoLogAspect {
    @Pointcut(value = "@annotation(org.oizehsgl.sub.annotation.DemoLog)")
    public void pointCut() {
    }

    /**
     * 前置通知：方法执行前调用
     */
    @Before(value = "pointCut() && @annotation(demoLog)")
    public String before(JoinPoint joinPoint, DemoLog demoLog) {
        log(joinPoint, demoLog);
        return Thread.currentThread().getStackTrace()[1].getMethodName();
    }

    /**
     * 环绕通知
     * 既可以在目标方法之前织入增强动作，也可以在执行目标方法之后织入增强动作；
     * 可以决定目标方法在什么时候执行，如何执行，甚至可以完全阻止目标目标方法的执行；
     * 可以改变执行目标方法的参数值，也可以改变执行目标方法之后的返回值； 当需要改变目标方法的返回值时，只能使用Around方法；
     */
    @Around("pointCut() && @annotation(demoLog)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, DemoLog demoLog) throws Throwable {
        log(proceedingJoinPoint, demoLog);
        try {
            System.out.println("--------------------方法执行前------------------------");
            Object resultObject = proceedingJoinPoint.proceed();
            System.out.println("--------------------方法执行后------------------------");
            return resultObject;
        } catch (Exception e) {
            return null;
        }

    }

    /**
     * 后置通知： 方法执行后调用，若方法出现异常，不执行
     */
    @AfterReturning(value = "pointCut() && @annotation(demoLog)", returning = "object")
    public void afterReturning(JoinPoint joinPoint, DemoLog demoLog, Object object) {
        log(joinPoint, demoLog, object);
    }

    /**
     * 异常通知：方法抛出异常时执行
     */
    @AfterThrowing(value = "pointCut() && @annotation(demoLog)", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, DemoLog demoLog, Throwable throwable) {
        log(joinPoint, demoLog, throwable);
    }

    /**
     * 最终通知：无论无何都会调用，类似于：try/catch中的finally
     */
    @After(value = "pointCut() && @annotation(demoLog)")
    public void after(JoinPoint joinPoint, DemoLog demoLog) {
        log(joinPoint, demoLog);
    }


    private void log(JoinPoint joinPoint, DemoLog demoLog) {
        log(joinPoint, demoLog, null, 3);
    }

    private void log(JoinPoint joinPoint, DemoLog demoLog, Object object) {
        log(joinPoint, demoLog, object, 3);
    }

    private void log(JoinPoint joinPoint, DemoLog demoLog, Object object, int i) {
        SourceLocation sourceLocation = joinPoint.getSourceLocation();
        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();
        System.out.printf("执行了%s方法%n", Thread.currentThread().getStackTrace()[i].getMethodName());
        System.out.printf("\t 切点:<%s>%n", joinPoint);
        Signature signature = joinPoint.getSignature();
        System.out.printf("\t 方法参数:<%s>%n", Arrays.toString(joinPoint.getArgs()));
        System.out.printf("\t 目标对象:<%s>%n", joinPoint.getTarget().getClass());
        System.out.printf("\t 代理对象:<%s>%n", joinPoint.getThis().getClass());
        System.out.printf("\t 类型:<%s>%n", joinPoint.getKind());
        System.out.printf("\t 静态信息:<%s>%n", staticPart);
        System.out.printf("\t 源码位置:<%s>%n", sourceLocation);
        System.out.printf("\t 方法签名:<%s>%n", signature);
        System.out.printf("\t 方法修饰:<%s>%n", Modifier.toString(signature.getModifiers()));
        System.out.printf("\t 类:<%s>%n", signature.getDeclaringType());
        System.out.printf("\t 类名:<%s>%n", signature.getDeclaringTypeName());
        System.out.printf("\t 方法名:<%s>%n", signature.getName());
        System.out.printf("\t 注解:<%s>%n", demoLog);
        System.out.printf("\t 返回或异常:<%s>%n", object);
        System.out.println();
    }
}
