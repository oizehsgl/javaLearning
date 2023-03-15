package org.oizehsgl.sub.controller;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.regex.Pattern;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * phone
 *
 * @author oizehsgl
 * @since 3/14/23
 */
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Repeatable(Phone.List.class)
@Documented
@Constraint(validatedBy = {Phone.Validator.class})
@ConstraintComposition(CompositionType.AND)
public @interface Phone {
    String message() default "{javax.validation.constraints.Phone.message:\u4e0d\u662f\u4e00\u4e2a\u5408\u6cd5\u7684\u624b\u673a\u53f7\u7801}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        Phone[] value();
    }

    class Validator implements ConstraintValidator<Phone, String> {
        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            if (value == null) {
                return false;
            }
            return Pattern.matches("^1[34578]\\d{9}$", value);
        }
    }
}
