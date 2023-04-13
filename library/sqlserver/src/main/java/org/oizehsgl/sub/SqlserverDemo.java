package org.oizehsgl.sub;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * sqlserverDemo
 *
 * @author oizehsgl
 * @since 4/13/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SqlserverDemo {
    private Long id;
    private Integer integer;
    private String string;
}
