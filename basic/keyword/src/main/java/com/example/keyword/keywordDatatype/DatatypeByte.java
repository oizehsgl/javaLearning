package com.example.keyword.keywordDatatype;

import org.openjdk.jol.info.ClassLayout;
import org.springframework.stereotype.Component;

/**
 * @author oizehsgl
 * @since 6/28/23
 */
@Component
public class DatatypeByte {
    byte aByte;

    public void test() {
        System.out.println(aByte);
        aByte = Byte.MIN_VALUE;
        System.out.println(aByte);
        aByte = Byte.MAX_VALUE;
        System.out.println(aByte);
        System.out.println(ClassLayout.parseInstance(aByte).toPrintable());
    }
}
