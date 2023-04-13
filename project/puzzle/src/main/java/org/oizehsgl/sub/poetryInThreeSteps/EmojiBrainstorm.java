package org.oizehsgl.sub.poetryInThreeSteps;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    Map<String, String> expressionMap = new HashMap<>(7);
}