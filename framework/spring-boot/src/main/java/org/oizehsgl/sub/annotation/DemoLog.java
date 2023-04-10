package org.oizehsgl.sub.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * demoLog
 *
 * @author oizehsgl
 * @since 4/10/23
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DemoLog {
    String value() default "";
}
