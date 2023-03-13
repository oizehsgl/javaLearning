package org.oizehsgl.sub;

import lombok.NonNull;
import lombok.Value;

/**
 * value
 *
 * @author oizehsgl
 * @since 3/13/23
 */
@Value
public class ValueAnnotation {
    @NonNull
    Object object;
    Integer integer;
    private static String string;
}
