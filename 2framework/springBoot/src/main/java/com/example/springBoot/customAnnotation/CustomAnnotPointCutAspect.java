package com.example.springBoot.customAnnotation;

import org.aspectj.lang.annotation.Pointcut;

/**
 * @author oizehsgl
 * @since 6/2/23
 */
public class CustomAnnotPointCutAspect {

    @Pointcut(value = "@annotation(com.example.springBoot.customAnnotation.annotation.CustomAnnotMethod)")
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

    @Pointcut("args()")
    public void pointCutArgs() {
    }

    @Pointcut("@args(com.example.springBoot.customAnnotation.annotation.CustomAnnotMethod)")
    public void pointCutAtArgs() {
    }

    @Pointcut("within(com.example.springBoot.customAnnotation.CustomAnnotSupService)")
    public void pointCutWithin() {
    }

    @Pointcut("@within(com.example.springBoot.customAnnotation.annotation.CustomAnnotMethod)")
    public void pointCutAtWithin() {
    }

    @Pointcut("target(com.example.springBoot.customAnnotation.CustomAnnotSupService)")
    public void pointCutTarget() {
    }

    @Pointcut("@target(com.example.springBoot.customAnnotation.annotation.CustomAnnotMethod)")
    public void pointCutAtTarget() {
    }

    @Pointcut("this(com.example.springBoot.customAnnotation.CustomAnnotSupService)")
    public void pointCutThis() {
    }

    @Pointcut("bean(customAnnotSupService)")
    public void pointCutBean() {
    }

    //@Pointcut("pointCutByMethod()")
    //@Pointcut("pointCutArgs()")
    //@Pointcut("pointCutAtArgs()")
    //@Pointcut("pointCutWithin()")
    //@Pointcut("pointCutAtWithin()")
    //@Pointcut("pointCutTarget()")
    @Pointcut("pointCutAtTarget()")
    //@Pointcut("pointCutThis()")
    //@Pointcut("pointCutBean()")
    public void pointCut() {
    }
}
