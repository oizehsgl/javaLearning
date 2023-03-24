package org.oizehsgl.sub;

import org.junit.Test;

import java.util.*;

/**
 * enumTest
 *
 * @author oizehsgl
 * @since 3/24/23
 */
public class EnumTest {
    @Test
    public void testEnumCompare() {
        System.out.println(null == EnumDemo.VALUE1);
        System.out.println(EnumDemo.VALUE1 == EnumDemo.VALUE1);
    }

    @Test
    public void testEnum() {
        Arrays.stream(EnumDemo.values()).forEach(System.out::println);
        System.out.println("EnumDemo.VALUE1.ordinal() = " + EnumDemo.VALUE1.ordinal());
        System.out.println(EnumDemo.valueOf("VALUE1").getString());
        EnumDemo.VALUE1.show();
        EnumDemo.VALUE2.show();
    }

    @Test
    public void testEnumSet() {
        EnumSet<EnumDemo> enumSet;
        enumSet = EnumSet.allOf(EnumDemo.class);
        System.out.println(enumSet);
        enumSet = enumSet.clone();
        System.out.println(enumSet);
        enumSet = EnumSet.noneOf(EnumDemo.class);
        System.out.println(enumSet);
        enumSet = EnumSet.complementOf(enumSet);
        System.out.println(enumSet);
        enumSet = EnumSet.copyOf(enumSet);
        System.out.println(enumSet);
        enumSet = EnumSet.copyOf(Arrays.asList(EnumDemo.VALUE2));
        System.out.println(enumSet);
        enumSet = EnumSet.range(EnumDemo.VALUE2, EnumDemo.VALUE3);
        System.out.println(enumSet);
        enumSet = EnumSet.of(EnumDemo.VALUE3, EnumDemo.VALUE1);
        System.out.println(enumSet);
    }

    @Test
    public void testEnumMap() {
        EnumMap<EnumDemo,EnumDemo> enumMap=new EnumMap<>(EnumDemo.class);
        enumMap.put(EnumDemo.VALUE1,EnumDemo.VALUE2);
        System.out.println(enumMap);
        enumMap=enumMap.clone();
        System.out.println(enumMap);
        System.out.println(enumMap.entrySet());
        System.out.println(enumMap.keySet());
        System.out.println(enumMap.values());
        System.out.println(enumMap.get(EnumDemo.VALUE1));
        System.out.println(enumMap.equals(enumMap));
        enumMap.putAll(new HashMap<>());
        System.out.println(enumMap);
        enumMap.put(EnumDemo.VALUE2,EnumDemo.VALUE3);
        System.out.println(enumMap);
        System.out.println(enumMap.containsKey(EnumDemo.VALUE1));
        System.out.println(enumMap.containsKey(EnumDemo.VALUE2));
        System.out.println(enumMap.containsValue(EnumDemo.VALUE1));
        System.out.println(enumMap.containsValue(EnumDemo.VALUE2));
        System.out.println(enumMap.size());
        enumMap.remove(EnumDemo.VALUE2);
        System.out.println(enumMap);
        enumMap.clear();
        System.out.println(enumMap);
    }

    @Test
    public void testEnumInterface() {
        EnumInterface enumInterface = EnumDemo.VALUE3;
        enumInterface.show();

    }
}
