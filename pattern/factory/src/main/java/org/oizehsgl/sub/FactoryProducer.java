package org.oizehsgl.sub;

/**
 * factoryProducer
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String className) {
        AbstractFactory abstractFactory = null;
        try {
            abstractFactory = (AbstractFactory) Class.forName(className).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return abstractFactory;
    }
}
