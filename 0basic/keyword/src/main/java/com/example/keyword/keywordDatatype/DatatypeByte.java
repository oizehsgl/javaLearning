package com.example.keyword.keywordDatatype;

import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 * @since 6/28/23
 */
@Component
public class DatatypeByte extends Datatype<Byte> {
    public void test() {
        test(Byte.MIN_VALUE, Byte.MAX_VALUE);
    }
}
