package org.oizehsgl.sub;

import java.util.Objects;

/**
 * proxyImage
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class ProxyImage extends Image{
    private RealImage realImage;
    public ProxyImage(String filePath) {
        super(filePath);
    }

    @Override
    void display() {
        if(Objects.isNull(realImage)){
            realImage=new RealImage(filePath);
        }
        realImage.display();
    }
}
