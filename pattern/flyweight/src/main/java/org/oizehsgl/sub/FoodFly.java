package org.oizehsgl.sub;

import java.util.concurrent.TimeUnit;

/**
 * foodFly
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class FoodFly implements Fly {
    private FlyFood flyFood;

    public FoodFly(FlyFood flyFood) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.flyFood = flyFood;
    }

    @Override
    public void eat() {
        System.out.println(flyFood);
    }
}
