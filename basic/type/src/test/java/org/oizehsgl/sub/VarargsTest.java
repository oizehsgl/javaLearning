package org.oizehsgl.sub;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * varargsTest
 *
 * @author oizehsgl
 * @since 3/24/23
 */
public class VarargsTest {
    @Test
    public void testVarargs() {
        String[] stringArray = {"1", "2", "3"};
        List<String> stringList = Arrays.asList("x", "y", "z");
        varargs(stringArray);
        varargs(stringList.toArray(new String[0]));
        varargs();
        varargs(null);
    }

    private void varargs(String... strings) {
        Optional.ofNullable(strings).ifPresent(s -> Arrays.stream(s).forEach(System.out::println));
    }
}
