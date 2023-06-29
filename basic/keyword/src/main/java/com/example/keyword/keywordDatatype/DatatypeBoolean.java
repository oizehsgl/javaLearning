package com.example.keyword.keywordDatatype;

import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 * @since 6/28/23
 */
@Component
public class DatatypeBoolean extends Datatype<Boolean> {
    public void test() {
        test(Boolean.FALSE, Boolean.TRUE);
    }
}
