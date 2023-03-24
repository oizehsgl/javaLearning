package org.oizehsgl.sub;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * enumDemo
 *
 * @author oizehsgl
 * @since 3/24/23
 */
@Getter
@AllArgsConstructor
public enum EnumDemo implements EnumInterface {
    VALUE1(1, "a") {

    }, VALUE2(2, "b") {
        @Override
        public void show() {
            System.out.println(EnumDemo.VALUE2);
        }

    }, VALUE3(3, "c") {
        @Override
        public void show() {
            System.out.println(EnumDemo.VALUE3);
        }

    };
    private Integer integer;
    private String string;

    @Override
    public void show() {
        System.out.println(EnumDemo.class.getSimpleName());
    }
}
