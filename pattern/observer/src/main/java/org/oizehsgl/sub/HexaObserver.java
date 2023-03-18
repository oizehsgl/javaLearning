package org.oizehsgl.sub;

/**
 * hexaObserver
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class HexaObserver extends Observer {

    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println(Integer.toHexString(subject.getState()));
    }
}
