package org.oizehsgl.sub;

/**
 * binaryObserver
 *
 * @author oizehsgl
 * @since 3/18/23
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println(Integer.toBinaryString(subject.getState()));
    }
}
