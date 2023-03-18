package org.oizehsgl.sub;

import java.util.Arrays;
import java.util.List;

/**
 * orExpression
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class OrExpression implements Expression {
    private List<Expression> expressionList;

    public OrExpression(Expression... expression) {
        expressionList = Arrays.asList(expression);
    }

    @Override
    public boolean interpret(String context) {
        boolean b = false;
        for (Expression expression : expressionList) {
            b = b || expression.interpret(context);
        }
        return b;
    }
}
