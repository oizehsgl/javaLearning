package org.oizehsgl.sub;

import lombok.Builder;
import lombok.NonNull;

/**
 * Builder
 *
 * @author oizehsgl
 * @since 3/13/23
 */
@Builder
public class BuilderAnnotation {
    @NonNull
    private Object object;
    private final Integer integer;
    private static String string;
}
