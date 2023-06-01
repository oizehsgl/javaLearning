package com.example.springBoot.customAnnotation;

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
 * @author oizehsgl
 * @since 6/1/23
 */
@Slf4j
@Aspect
@Order(0)
@Component
public class CustomAnnotAspect {
    @Pointcut(value = "@annotation(com.example.springBoot.customAnnotation.CustomAnnot)")
    public void pointCutByAnnotation() {
    }

    /// 父类方法切面后子类继承的方法自动会切面
    //@Pointcut(value = "execution(public * com.example.springBoot.customAnnotation.CustomAnnotSupService+.method(..))")
    @Pointcut(value = "execution(public * com.example.springBoot.customAnnotation.CustomAnnotSupService.method(..))")
    //@Pointcut(value = "execution(public * com.example.springBoot.customAnnotation.CustomAnnotSupService.m*d(..))")
    //@Pointcut(value = "execution(public * com.example.springBoot.customAnnotation.CustomAnnotSubService.method(..))")
    //@Pointcut(value = "execution(public * com.example.springBoot.customAnnotation.CustomAnnotSubService.m*d(..))")
    //@Pointcut(value = "execution(public * com.example.springBoot.customAnnotation.*.*(..))")
    //@Pointcut(value = "execution(public * com.example.springBoot.customAnnotation..*(..))")
    //@Pointcut(value = "execution(public * com.example.springBoot.customAnnotation..*d(..))")
    public void pointCutByMethod() {
    }

    @Pointcut("pointCutByMethod()")
    public void pointCut() {
    }

    /**
     * 前置通知：方法执行前调用
     */
    @Before(value = "pointCut() && @annotation(customAnnot)")
    public void before(JoinPoint joinPoint, CustomAnnot customAnnot) {
        SourceLocation sourceLocation = joinPoint.getSourceLocation();
        JoinPoint.StaticPart staticPart = joinPoint.getStaticPart();
        Signature signature = joinPoint.getSignature();
        System.out.printf("before\t切点:<%s>%n", joinPoint);
        System.out.printf("before\t方法参数:<%s>%n", Arrays.toString(joinPoint.getArgs()));
        System.out.printf("before\t目标对象:<%s>%n", joinPoint.getTarget().getClass());
        System.out.printf("before\t代理对象:<%s>%n", joinPoint.getThis().getClass());
        System.out.printf("before\t类型:<%s>%n", joinPoint.getKind());
        System.out.printf("before\t静态信息:<%s>%n", staticPart);
        System.out.printf("before\t源码位置:<%s>%n", sourceLocation);
        System.out.printf("before\t方法签名:<%s>%n", signature);
        System.out.printf("before\t方法修饰:<%s>%n", Modifier.toString(signature.getModifiers()));
        System.out.printf("before\t类:<%s>%n", signature.getDeclaringType());
        System.out.printf("before\t类名:<%s>%n", signature.getDeclaringTypeName());
        System.out.printf("before\t方法名:<%s>%n", signature.getName());
        System.out.printf("before\t注解:<%s>%n", customAnnot);
    }

    /**
     * 环绕通知
     * 既可以在目标方法之前织入增强动作，也可以在执行目标方法之后织入增强动作；
     * 可以决定目标方法在什么时候执行，如何执行，甚至可以完全阻止目标目标方法的执行；
     * 可以改变执行目标方法的参数值，也可以改变执行目标方法之后的返回值； 当需要改变目标方法的返回值时，只能使用Around方法；
     */
    @Around("pointCut() && @annotation(customAnnot)")
    public void around(ProceedingJoinPoint proceedingJoinPoint, CustomAnnot customAnnot) {
        System.out.printf("around\t注解:<%s>%n", customAnnot);
        try {
            Object r = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 后置通知： 方法执行后调用，若方法出现异常，不执行
     */
    @AfterReturning(value = "pointCut() && @annotation(customAnnot)", returning = "object")
    public void afterReturning(JoinPoint joinPoint, CustomAnnot customAnnot, Object object) {
        System.out.printf("afterReturning\t返回:<%s>%n", object);
    }

    /**
     * 异常通知：方法抛出异常时执行
     */
    @AfterThrowing(value = "pointCut() && @annotation(customAnnot)", throwing = "throwable")
    public void afterThrowing(JoinPoint joinPoint, CustomAnnot customAnnot, Throwable throwable) {
        System.out.printf("afterThrowing\t异常:<%s>%n", throwable);
    }

    /**
     * 最终通知：无论无何都会调用，类似于：try/catch中的finally
     */
    @After(value = "pointCut() && @annotation(customAnnot)")
    public void after(JoinPoint joinPoint, CustomAnnot customAnnot) {
        System.out.printf("after%n");
    }
}
