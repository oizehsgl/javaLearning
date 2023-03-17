package org.oizehsgl.sub;

import java.util.concurrent.TimeUnit;

/**
 * realImage
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class RealImage extends Image {
    public RealImage(String filePath) {
        super(filePath);
        load();
    }

    @Override
    void display() {
        System.out.println(filePath);
    }
    void load(){
        System.out.println("......");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
