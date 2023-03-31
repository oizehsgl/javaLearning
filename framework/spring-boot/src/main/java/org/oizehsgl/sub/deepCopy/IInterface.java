package org.oizehsgl.sub.deepCopy;

import java.io.Serializable;

/**
 * iString
 *
 * @author oizehsgl
 * @since 3/31/23
 */
public interface IInterface extends Serializable {
    String getString();

    void setString(String string);

    void addList0();
    DeepCopyDemo getDeepCopyDemo();
}
