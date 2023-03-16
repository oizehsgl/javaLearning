package org.oizehsgl.sub;

import java.util.List;

/**
 * abstractFilter
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public interface AbstractFilter {
    List<Subject> subjectFilter(List<Subject> subjectList);
}
