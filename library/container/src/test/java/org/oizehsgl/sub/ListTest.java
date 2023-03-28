package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Stream;

/**
 * listTest
 *
 * @author oizehsgl
 * @since 3/28/23
 */
@SpringBootTest
public class ListTest {
    @Test
    public void testArrayList(){
        ArrayList<Integer> list = new ArrayList<>();
        Stream.iterate(0, i->i+1).limit(100).parallel().forEach(list::add);
        System.out.println(list.size());
    }
    @Test
    public void testLinkedList(){
        LinkedList<Integer> list = new LinkedList<>();
        Stream.iterate(0, i->i+1).limit(100).parallel().forEach(list::add);
        System.out.println(list.size());
    }
}
