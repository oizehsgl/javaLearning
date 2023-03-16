package org.oizehsgl.sub;

import java.util.Objects;

/**
 * demoLeaf
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class DemoLeaf extends DemoComponent {
    public DemoLeaf(Integer level) {
        super(level);
    }

    @Override
    public void add(DemoComponent demoComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public DemoComponent getChild(Integer level) {
        if (Objects.equals(getLevel(), level)) {
            return this;
        }
        return null;
    }

    @Override
    public Integer getCount() {
        return 1;
    }
}
