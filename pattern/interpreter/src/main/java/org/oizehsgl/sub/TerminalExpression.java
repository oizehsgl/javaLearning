package org.oizehsgl.sub;

/**
 * terminalExpression
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if (context.contains(data)) {
            return true;
        }
        return false;
    }
}
