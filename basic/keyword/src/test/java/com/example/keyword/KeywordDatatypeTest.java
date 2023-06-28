package com.example.keyword;

import com.example.keyword.keywordDatatype.DatatypeByte;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 * @since 6/28/23
 */
@SpringBootTest
public class KeywordDatatypeTest {
    @Resource
    DatatypeByte datatypeByte;
    @Test
    public void testByte(){
        datatypeByte.test();
    }
}
