package org.oizehsgl.sub;

import org.junit.Test;

/**
 * iteratorTest
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class IteratorTest {
    @Test
    public void testIterator() {
        NameRepository namesRepository = new NameRepository();
        for (Iterator iter = namesRepository.getIterator(); iter.hasNext(); ) {
            System.out.printf("name: %s%n", iter.next());
        }
    }
}
