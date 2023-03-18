package org.oizehsgl.sub;

/**
 * computerPartVisitor
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public interface ComputerPartVisitor {
    void visit(Computer computer);

    void visit(Mouse mouse);

    void visit(Keyboard keyboard);
}
