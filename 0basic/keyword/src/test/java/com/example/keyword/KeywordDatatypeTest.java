package com.example.keyword;

import com.example.keyword.keywordDatatype.Datatype;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author oizehsgl
 * @since 6/28/23
 */
@SpringBootTest
public class KeywordDatatypeTest {
    @Resource
    List<Datatype> datatypeList;
    @Test
    public void testByte(){
        datatypeList.forEach(Datatype::test);
    }
}
