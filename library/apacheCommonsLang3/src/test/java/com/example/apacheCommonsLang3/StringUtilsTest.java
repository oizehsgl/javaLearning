package com.example.apacheCommonsLang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

/**
 * @author oizehsgl
 * @since 5/30/23
 */
@SpringBootTest
public class StringUtilsTest {
    @Test
    public void testSplit(){
        String str=",a,b,,c,.d..e.f.";
        String separatorChars=",.";
        Stream.of(StringUtils.split(str, separatorChars)).forEach(System.out::println);
    }

    private void abbreviate(String str){
        System.out.printf("<%s> --> <%s>%n",str,StringUtils.abbreviate(str,"" ,5));
    }
    @Test
    public void testAbbreviate(){
        abbreviate(null);
        abbreviate("");
        abbreviate("0123");
        abbreviate("01234");
        abbreviate("01234567");
        abbreviate("中文测试五个字");
    }
}
