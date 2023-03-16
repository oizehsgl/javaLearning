package org.oizehsgl.sub;

import org.junit.Test;

/**
 * factoryTest
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class FactoryTest {
    @Test
    public void testFirst() {
        FirstFactory firstFactory = new FirstFactory();
        Arab arab;
        arab = firstFactory.getArab(One.class.getName());
        arab.write();
        arab = firstFactory.getArab(Two.class.getName());
        arab.write();
        arab = firstFactory.getArab(Three.class.getName());
        arab.write();
    }

    @Test
    public void testSecond() {
        SecondFactory secondFactory = new SecondFactory();
        Greek greek;
        greek = secondFactory.getGreek(Alpha.class.getName());
        greek.write();
        greek = secondFactory.getGreek(Beta.class.getName());
        greek.write();
        greek = secondFactory.getGreek(Gamma.class.getName());
        greek.write();
    }

    @Test
    public void testFactory() {
        AbstractFactory abstractFactory = FactoryProducer.getFactory(FirstFactory.class.getName());
        Arab arab;
        arab = abstractFactory.getArab(One.class.getName());
        arab.write();
        arab = abstractFactory.getArab(Two.class.getName());
        arab.write();
        arab = abstractFactory.getArab(Three.class.getName());
        arab.write();
    }
}
