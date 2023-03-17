package org.oizehsgl.sub;

import org.junit.Test;

/**
 * decoratorTest
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class DecoratorTest {
    @Test
    public void testDecorator(){
        Drink drink = new Cola();
        System.out.printf("name: %s cost: %s%n",drink.getName(),drink.cost());
        drink = new Sugar(drink);
        System.out.printf("name: %s cost: %s%n",drink.getName(),drink.cost());
        drink = new Ice(drink);
        System.out.printf("name: %s cost: %s%n",drink.getName(),drink.cost());
    }
}
