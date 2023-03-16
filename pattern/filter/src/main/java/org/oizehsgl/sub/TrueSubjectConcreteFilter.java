package org.oizehsgl.sub;

import java.util.ArrayList;
import java.util.List;

/**
 * trueSubjectConcreteFilter
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class TrueSubjectConcreteFilter implements AbstractFilter {
    @Override
    public List<Subject> subjectFilter(List<Subject> subjectList) {
        List<Subject> subjects = new ArrayList<>();
        for (Subject subject : subjectList) {
            if (subject.getaBoolean()) {
                subjects.add(subject);
            }
        }
        return subjects;
    }
}
