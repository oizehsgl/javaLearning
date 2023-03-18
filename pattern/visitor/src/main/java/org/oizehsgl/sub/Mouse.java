package org.oizehsgl.sub;

/**
 * mouse
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class Mouse implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}
