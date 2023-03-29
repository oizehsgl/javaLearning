package org.oizehsgl.sub.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.group.GroupSequenceProvider;

import java.util.List;

/**
 * demoData
 *
 * @author oizehsgl
 * @since 3/13/23
 */
@Data
@Builder
@GroupSequenceProvider(DemoSequenceProvider.class)
public class DemoData {
    @Length(min = 2, max = 4)
    private String length;
    @NotNull
    @Range(min = 2, max = 4)
    private Integer range;
    @Pattern(regexp = "^(0x)?[0-9a-fA-F]+$")
    private String pattern;
    @Valid
    @Size(min = 2, max = 4)
    private List<DemoElement> size;
}