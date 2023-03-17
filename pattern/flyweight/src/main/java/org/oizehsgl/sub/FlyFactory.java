package org.oizehsgl.sub;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * flyFactory
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class FlyFactory {
    private static final Map<FlyFood, Fly> map = new HashMap<>();

    public static Fly get(FlyFood flyFood) {
        Fly fly = map.get(flyFood);
        if (Objects.isNull(fly)) {
            fly = new FoodFly(flyFood);
            map.put(flyFood, fly);
        }
        return fly;
    }
}
