package org.oizehsgl.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * demoComposite
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class DemoComposite extends DemoComponent {
    private List<DemoComponent> demoComponentList = new ArrayList<>();

    public DemoComposite(Integer level) {
        super(level);
    }

    @Override
    public void add(DemoComponent demoComponent) {
        demoComponentList.add(demoComponent);
    }

    @Override
    public DemoComponent getChild(Integer level) {
        for (DemoComponent demoComponent : demoComponentList) {
            DemoComponent targetDemoComponent = demoComponent.getChild(level);
            if (Objects.nonNull(targetDemoComponent)) {
                return targetDemoComponent;
            }
        }
        return null;
    }

    @Override
    public Integer getCount() {
        Integer count = 1;
        for (DemoComponent component : demoComponentList) {
            count += component.getCount();
        }
        return count;
    }
}
