package org.oizehsgl.sub;

/**
 * sugar
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class Sugar extends DrinkCondimentDecorator {
    Drink drink;

    public Sugar(Drink drink) {
        this.drink = drink;
    }

    @Override
    public Integer cost() {
        return 10 + drink.cost();
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName() + drink.getName();
    }
}
