package org.oizehsgl.sub.poetryInThreeSteps;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * emojiBrainstorm
 *
 * @author oizehsgl
 * @since 4/12/23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmojiBrainstorm {
    List<String> expressions = new ArrayList<>(7);
}