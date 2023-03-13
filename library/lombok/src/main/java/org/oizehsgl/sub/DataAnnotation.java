package org.oizehsgl.sub;

import lombok.*;
import lombok.experimental.Accessors;

/**
 * data
 *
 * @author oizehsgl
 * @since 3/13/23
 */
@Data
@Setter(AccessLevel.PROTECTED)
@Getter(AccessLevel.PROTECTED)
@ToString(exclude = "integer", callSuper = true, includeFieldNames = true)
@EqualsAndHashCode(exclude = {"object", "integer"}, callSuper = false)
@RequiredArgsConstructor(staticName = "of")
@Accessors(fluent = false)
public class DataAnnotation {
    @NonNull
    private Object object;
    private final Integer integer;
    private static String string;

    @Getter(lazy = true)
    private final double[] cached = expensive();

    private double[] expensive() {
        double[] result = new double[10];
        for (int i = 0; i < result.length; i++) {
            result[i] = Math.asin(i);
        }
        return result;
    }

    /*
    private final AtomicReference<Object> cached = new AtomicReference();

    public double[] getCached() {
        Object value = this.cached.get();
        if (value == null) {
            synchronized(this.cached) {
                value = this.cached.get();
                if (value == null) {
                    double[] actualValue = this.expensive();
                    value = actualValue == null ? this.cached : actualValue;
                    this.cached.set(value);
                }
            }
        }
        return (double[])(value == this.cached ? null : value);
    }
     */

}
