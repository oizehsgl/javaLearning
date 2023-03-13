package org.oizehsgl.sub;

import lombok.NonNull;

/**
 * NoNull
 *
 * @author oizehsgl
 * @since 3/13/23
 */
public class NonNullAnnotation {
    public void nonNull(@NonNull NonNullAnnotation nonNullAnnotation) {
        System.out.println("nonNullAnnotation = " + nonNullAnnotation);
    }
}
