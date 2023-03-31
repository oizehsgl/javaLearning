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
public class DeepCopyDemo implements Serializable, IInterface {
    private Integer integer;
    private String string;
    private List<Integer> integerList;
    private DeepCopyDemo deepCopyDemo;

    public DeepCopyDemo deepCopy() {
        return null;
    }

    @Override
    public void addList0() {
        integerList.set(0, integerList.get(0) + 1);
    }
}
