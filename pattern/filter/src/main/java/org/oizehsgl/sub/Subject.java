package org.oizehsgl.sub;

/**
 * subject
 *
 * @author oizehsgl
 * @since 3/16/23
 */
public class Subject {
    private Boolean aBoolean;
    private Integer aInteger;

    public Subject(Boolean aBoolean, Integer aInteger) {
        this.aBoolean = aBoolean;
        this.aInteger = aInteger;
    }

    public Boolean getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public Integer getaInteger() {
        return aInteger;
    }

    public void setaInteger(Integer aInteger) {
        this.aInteger = aInteger;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "aBoolean=" + aBoolean +
                ", aInteger=" + aInteger +
                '}';
    }
}
