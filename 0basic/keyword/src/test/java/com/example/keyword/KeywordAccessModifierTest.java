package com.example.keyword;

import com.example.keyword.keywordAccessModifier.KeywordPublicSubclass;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author oizehsgl
 * @since 6/28/23
 */
@SpringBootTest
public class KeywordAccessModifierTest {
    @Resource
    KeywordPublicSubclass keywordPublicSubclass;
    @Test
    public void test(){
        keywordPublicSubclass.testMethod();
    }
}
