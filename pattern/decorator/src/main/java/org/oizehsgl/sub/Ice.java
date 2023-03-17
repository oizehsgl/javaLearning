package org.oizehsgl.sub;

/**
 * ice
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class Ice extends DrinkCondimentDecorator {
    Drink drink;

    public Ice(Drink drink) {
        this.drink = drink;
    }

    @Override
    public Integer cost() {
        return 1 + drink.cost();
    }

    @Override
    public String getName() {
        return this.getClass().getSimpleName()+drink.getName() ;
    }
}
