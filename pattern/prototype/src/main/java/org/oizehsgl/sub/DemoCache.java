package org.oizehsgl.sub;

import java.util.HashMap;
import java.util.Map;

/**
 * demoCache
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class DemoCache {
    private static Map<Integer, DemoPrototype> map = new HashMap<>();

    public static DemoPrototype getDemoPrototype(Integer key) {
        DemoPrototype demoPrototype = map.get(key);
        return demoPrototype.clone();
    }

    public static void loadCache() {
        AlphaDemoPrototype alphaDemoPrototype = new AlphaDemoPrototype();
        alphaDemoPrototype.setKey(1);
        map.put(alphaDemoPrototype.getKey(), alphaDemoPrototype);
        BetaDemoPrototype betaDemoPrototype = new BetaDemoPrototype();
        betaDemoPrototype.setKey(2);
        map.put(betaDemoPrototype.getKey(), betaDemoPrototype);
    }
}
