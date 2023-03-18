package org.oizehsgl.sub;

import org.junit.Test;

/**
 * interpreterTest
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class InterpreterTest {
    @Test
    public void testInterpreter() {
        Expression two = new TerminalExpression("2");
        Expression three = new TerminalExpression("3");
        Expression five = new TerminalExpression("5");
        Expression prime = new OrExpression(two, three, five);
        System.out.printf("%s is prime? %s%n", "1", prime.interpret("1"));
        System.out.printf("%s is prime? %s%n", "3", prime.interpret("3"));
    }
}
