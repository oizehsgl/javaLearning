package org.oizehsgl.sub;

/**
 * keyboard
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class Keyboard implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
