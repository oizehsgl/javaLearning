package org.oizehsgl.sub;

/**
 * computerPart
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public interface ComputerPart {
    void accept(ComputerPartVisitor computerPartVisitor);
}