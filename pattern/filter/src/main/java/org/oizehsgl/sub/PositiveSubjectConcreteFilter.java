package org.oizehsgl.sub;

import java.util.ArrayList;
import java.util.List;

/**
 * positiveSubjectConcreteFilter
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class PositiveSubjectConcreteFilter implements AbstractFilter {
    @Override
    public List<Subject> subjectFilter(List<Subject> subjectList) {
        List<Subject> subjects = new ArrayList<>();
        for (Subject subject : subjectList) {
            if (subject.getaInteger() > 0) {
                subjects.add(subject);
            }
        }
        return subjects;
    }
}
