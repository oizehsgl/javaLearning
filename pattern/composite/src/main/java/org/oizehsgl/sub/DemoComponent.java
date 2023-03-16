package org.oizehsgl.sub;

/**
 * demoComponent
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public abstract class DemoComponent {
    private Integer level;

    public abstract void add(DemoComponent demoComponent);

    public abstract DemoComponent getChild(Integer level);

    public abstract Integer getCount();

    public Integer getLevel() {
        return level;
    }

    public DemoComponent(Integer level) {
        this.level = level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "DemoComponent{" +
                "level=" + level +
                '}';
    }
}
