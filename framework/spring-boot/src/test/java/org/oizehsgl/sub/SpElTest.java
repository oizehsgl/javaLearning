package org.oizehsgl.sub;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * spElTest
 *
 * @author oizehsgl
 * @since 4/6/23
 */
@SpringBootTest
public class SpElTest {
    private final SpelExpressionParser spelExpressionParser = new SpelExpressionParser();
    public final static String spel = "{T(org.oizehsgl.sub.SpElTest).get(T(org.oizehsgl.sub.SpElTest).string)}";
    @Value(value ="#"+spel)
    private String value;

    @Test
    public void testSpEl() {
        System.out.println(spelExpressionParser.parseExpression("'hello world'").getValue());
        System.out.println(spelExpressionParser.parseExpression("'hello world'.concat('!')").getValue());
        System.out.println(spelExpressionParser.parseExpression("'hello world'.toUpperCase()").getValue());
        System.out.println(spelExpressionParser.parseExpression("'hello world'.bytes").getValue());
        System.out.println(spelExpressionParser.parseExpression("{T(java.lang.Math).random()}").getValue());
        System.out.println(spelExpressionParser.parseExpression(spel).getValue());
        System.out.println(value);
        System.out.println(spelExpressionParser.parseExpression("{'1','2'}.contains('1')").getValue());
    }

    public static String string = "staticString";

    public static String get(String s) {
        return s;
    }
}
