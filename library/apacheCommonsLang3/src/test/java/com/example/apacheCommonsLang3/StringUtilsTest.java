package com.example.apacheCommonsLang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author oizehsgl
 * @since 5/30/23
 */
@SpringBootTest
public class StringUtilsTest {
    static class testSplitArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of("", ""),
                    Arguments.of("", ","),
                    Arguments.of("a,b", ""),
                    Arguments.of("a,b", ","),
                    Arguments.of("a,,b", ","),
                    Arguments.of("a,,b", ",,"),
                    Arguments.of("a,.b", ",."),
                    Arguments.of("a,.b", null),
                    Arguments.of(null, ",."),
                    Arguments.of((Object) null, (Object) null));
        }
    }

    @ParameterizedTest
    @ArgumentsSource(testSplitArgumentProvider.class)
    public void testSplit(String str, String separatorChars) {
        System.out.printf("<%s> + <%s> -> %s%n",str,separatorChars,Arrays.toString(StringUtils.split(str, separatorChars)));
    }

    static class testAbbreviateArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(""),
                    Arguments.of("0123"),
                    Arguments.of("01234"),
                    Arguments.of("012345"),
                    Arguments.of("中文截取测试"),
                    Arguments.of((Object) null));
        }
    }

    @ParameterizedTest
    @ArgumentsSource(testAbbreviateArgumentProvider.class)
    public void testAbbreviate(String str) {
        System.out.printf("<%s> --> <%s>%n", str, StringUtils.abbreviate(str, "", 5));
    }
}
