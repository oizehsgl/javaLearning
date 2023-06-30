package com.example.springBoot.customAnnotation.annotation;

import java.lang.annotation.*;

/**
 * @author oizehsgl
 * @since 6/1/23
 */
@Inherited
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomAnnotInherit {
    String value() default "";
}