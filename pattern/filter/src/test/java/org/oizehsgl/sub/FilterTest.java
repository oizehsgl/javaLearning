package org.oizehsgl.sub;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * filterTest
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class FilterTest {
    @Test
    public void testFilter(){
        List<Subject> subjectList = new ArrayList<>();
        subjectList.add(new Subject(false,-1));
        subjectList.add(new Subject(false,1));
        subjectList.add(new Subject(true,-1));
        subjectList.add(new Subject(true,1));
        System.out.println(subjectList);
        subjectList=new TrueSubjectConcreteFilter().subjectFilter(subjectList);
        System.out.println(subjectList);
        subjectList=new PositiveSubjectConcreteFilter().subjectFilter(subjectList);
        System.out.println(subjectList);
    }
}
