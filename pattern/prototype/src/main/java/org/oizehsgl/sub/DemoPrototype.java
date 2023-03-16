package org.oizehsgl.sub;

/**
 * demoPrototype
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public abstract class DemoPrototype implements Cloneable {

    private Integer key;

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    protected String value;

    abstract void write();

    @Override
    public DemoPrototype clone() {
        DemoPrototype demoPrototype = null;
        try {
            demoPrototype = (DemoPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return demoPrototype;
    }
}
