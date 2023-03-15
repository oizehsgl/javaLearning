package org.oizehsgl.sub.controller;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Negative;

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
