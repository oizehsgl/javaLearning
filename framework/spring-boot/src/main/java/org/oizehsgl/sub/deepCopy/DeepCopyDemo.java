package org.oizehsgl.sub.deepCopy;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * deepCopyDemo
 *
 * @author oizehsgl
 * @since 3/31/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeepCopyDemo implements Serializable {
    private Integer integer;
    private String string;
    private List<Integer> integerList;

    public DeepCopyDemo deepCopy() {
        return null;
    }
}
