package org.oizehsgl.sub;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * cacheDemo
 *
 * @author oizehsgl
 * @since 4/7/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CacheDemo implements Serializable {
    private Integer integer;
    private String string;
}
