package org.oizehsgl.sub.controller;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * demoSequenceProvider
 *
 * @author oizehsgl
 * @since 3/13/23
 */
public class DemoSequenceProvider implements DefaultGroupSequenceProvider<DemoData> {
    @Override
    public List<Class<?>> getValidationGroups(DemoData demoData) {
        List<Class<?>> defaultGroupSequence = new ArrayList<>();

        defaultGroupSequence.add(DemoData.class);

        if (demoData != null && demoData.getRange() != null && demoData.getRange() % 2 == 0) {
            defaultGroupSequence.add(ValidatedGroup.Insert.class);
        }

        if (demoData != null && demoData.getRange() != null && demoData.getRange() % 2 == 1) {
            defaultGroupSequence.add(ValidatedGroup.Update.class);
        }

        return defaultGroupSequence;
    }
}
