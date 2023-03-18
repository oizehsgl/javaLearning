package org.oizehsgl.sub;

import java.util.ArrayList;
import java.util.List;

/**
 * careTaker
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class CareTaker {

    private List<Memento> mementoList = new ArrayList<>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return mementoList.get(index);
    }
}
