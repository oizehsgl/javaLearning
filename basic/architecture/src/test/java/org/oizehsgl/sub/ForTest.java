package org.oizehsgl.sub;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * forTest
 *
 * @author oizehsgl
 * @since 3/28/23
 */
public class ForTest {
    @Test
    public void testFor() {
        List<Integer> integerList = Arrays.asList(1, 2, null);
        for (Integer integer : integerList) {
            try {
                System.out.println(integer.toString());
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("e = " + e);
                System.out.println("e.getMessage() = " + e.getMessage());
                System.out.println("e.getCause() = " + e.getCause());
                System.out.println("e.getLocalizedMessage() = " + e.getLocalizedMessage());
                System.out.println("e.getSuppressed() = " + e.getSuppressed());
                System.out.println("e.getStackTrace() = " + e.getStackTrace());
                System.out.println("e.getStackTrace()[0] = " + e.getStackTrace()[0]);
            }
        }
    }
}
