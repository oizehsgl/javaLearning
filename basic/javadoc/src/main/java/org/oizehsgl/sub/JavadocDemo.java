/**
 * Provides the classes necessary to create an applet and the classes an applet uses
 * to communicate with its applet context.
 * <p>
 * The applet framework involves two entities:
 * the applet and the applet context. An applet is an embeddable window (see the
 * {@link java.awt.Panel} class) with a few extra methods that the applet context
 * can use to initialize, start, and stop the applet.
 *
 * @see java.awt
 * @since 1.0
 */
package org.oizehsgl.sub;

import java.awt.*;
import java.awt.image.ImageObserver;

/**
 * main description.&nbsp;this is
 * javadocDemo.
 * <p>
 * this is paragraph.this
 * is paragraph.
 * <ul>
 *     <li>first
 *     <li>second
 *     <li>third
 * </ul>
 * <p>
 * this is paragraph.this
 * is paragraph.
 *
 * @author oizehsgl
 * @author <a href="oizehsgl@gmail.com">oizehsgl</a>
 * @version 1.8.3.4
 * @since 4/4/23
 * @since 1.4
 * @since JDK1.5
 * {@code true}
 * {@code null}
 * {@code CharSequence}
 * {@code int var = 1;}
 */
public class JavadocDemo {
    /**
     * Draws as much of the specified image as is currently available
     * with its northwest corner at the specified coordinate (x, y).
     * This method will return immediately in all cases.
     * <p>
     * If the current output representation is not yet complete then
     * the method will return false and the indicated
     * {@link ImageObserver} object will be notified as the
     * conversion process progresses.
     * 可以放在{@inheritDoc}描述部分，return param throws
     *
     * @param img      the image to be drawn
     * @param x        the x-coordinate of the northwest corner
     *                 of the destination rectangle in pixels
     * @param y        the y-coordinate of the northwest corner
     *                 of the destination rectangle in pixels
     * @param observer the image observer to be notified as more
     *                 of the image is converted.  May be
     *                 <code>null</code>
     * @return <code>true</code> if the {@code img} is completely
     * loaded and was painted successfully;
     * <code>false</code> otherwise.
     * @throws Exception if exception
     *                   <p>
     *                   Example of calling the method:
     *                   <pre>
     *                   public void main(String[] args) {
     *                   	System.out.println(factorial(5));
     *                   }
     *                   </pre>
     *                   <p>
     *                   Example of calling the method:
     *                   public void main(String[] args) {
     *                   System.out.println(factorial(5));
     *                   }
     * @see App
     * @see ImageObserver
     * @since 1.0
     * 方法{@link String#charAt(int)}返回,和{@linkplain String#charAt(int) charAt}一致
     * * @deprecated As of JDK 1.1, replaced by
     * {@link #drawImage(Image, int, int, ImageObserver)}
     */
    public boolean drawImage(Image img, int x, int y, ImageObserver observer) throws Exception {
        return true;
    }

    /**
     * the static field {@value #ABC}
     */
    public static int ABC = 1;
}
