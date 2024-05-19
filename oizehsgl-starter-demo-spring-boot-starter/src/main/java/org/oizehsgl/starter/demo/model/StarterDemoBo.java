package org.oizehsgl.starter.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author oizehsgl
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StarterDemoBo {
    private String id;
    private String code;
    private String name;
}
