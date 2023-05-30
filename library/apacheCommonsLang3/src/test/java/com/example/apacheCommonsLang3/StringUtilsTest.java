package com.example.apacheCommonsLang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.Stream;

/**
 * @author oizehsgl
 * @since 5/30/23
 */
@SpringBootTest
public class StringUtilsTest {
    @Test
    public void testSplit() {
        String str = ",a,b,,c,.d..e.f.";
        String separatorChars = ",.";
        Stream.of(StringUtils.split(str, separatorChars)).forEach(System.out::println);
    }

    @ParameterizedTest
    @CsvSource({
            ",",
            "''",
            "'''",
            "0123",
            "01234",
            "012345",
            "中文截取测试",
    })
    public void testAbbreviate(String str) {
        System.out.printf("<%s> --> <%s>%n", str, StringUtils.abbreviate(str, "", 5));
    }
}
