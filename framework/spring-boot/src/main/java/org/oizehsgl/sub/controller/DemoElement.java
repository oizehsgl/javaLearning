package org.oizehsgl.sub.controller;

import jakarta.validation.constraints.Negative;
import lombok.Builder;
import lombok.Data;


/**
 * demoElement
 *
 * @author oizehsgl
 * @since 3/13/23
 */
@Data
@Builder
public class DemoElement {
    @Phone
    private String phone;
    @Negative
    private Integer negative;
}
