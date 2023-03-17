package org.oizehsgl.sub;

/**
 * image
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public abstract class Image {
    protected String filePath;

    public Image(String filePath) {
        this.filePath = filePath;

    }

    abstract void display();
}
