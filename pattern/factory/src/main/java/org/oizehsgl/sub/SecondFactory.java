package org.oizehsgl.sub;

/**
 * greekFactory
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class SecondFactory extends AbstractFactory {
    @Override
    public Greek getGreek(String className) {
        Greek greek = null;
        try {
            greek = (Greek) Class.forName(className).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return greek;
    }

    @Override
    public Arab getArab(String className) {
        Arab arab = null;
        try {
            arab = (Arab) Class.forName(className).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return arab;
    }
}
