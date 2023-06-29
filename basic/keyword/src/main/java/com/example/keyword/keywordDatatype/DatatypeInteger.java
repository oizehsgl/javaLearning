package com.example.keyword.keywordDatatype;

import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 * @since 6/28/23
 */
@Component
public class DatatypeInteger extends Datatype<Integer> {
    public void test() {
        test(Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}
