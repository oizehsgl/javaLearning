package org.oizehsgl.sub.controller;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * customSequenceProvider
 *
 * @author oizehsgl
 * @since 3/13/23
 */
public class CustomSequenceProvider implements DefaultGroupSequenceProvider<DemoData> {
    @Override
    public List<Class<?>> getValidationGroups(DemoData demoData) {
        List<Class<?>> defaultGroupSequence = new ArrayList<>();

        defaultGroupSequence.add(DemoData.class);

        if (demoData != null && demoData.getInteger() % 2 == 0) {
            defaultGroupSequence.add(Group.Insert.class);
        }

        if (demoData != null && demoData.getInteger() % 2 == 1) {
            defaultGroupSequence.add(Group.Update.class);
        }

        return defaultGroupSequence;
    }
}
