package org.oizehsgl.sub;

/**
 * octalObserver
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println(Integer.toOctalString(subject.getState()));
    }
}
