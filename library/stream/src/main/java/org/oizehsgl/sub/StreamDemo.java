package org.oizehsgl.sub;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * streamDemo
 *
 * @author oizehsgl
 * @since 3/23/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StreamDemo {
    private Integer integer;
    private String string;
    private Character character;
}
