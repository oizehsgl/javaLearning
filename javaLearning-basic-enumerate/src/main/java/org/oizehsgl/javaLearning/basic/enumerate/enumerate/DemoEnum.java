package org.oizehsgl.javaLearning.basic.enumerate.enumerate;

import ch.qos.logback.core.testUtil.RandomUtil;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

/**
 * 示例枚举
 *
 * @author yueyuanzhi
 */
@Getter
@RequiredArgsConstructor
public enum DemoEnum implements IDemoEnum {
    DEMO1(1, "demo1"),
    DEMO2(2, "demo2"),
    DEMO3(3, "demo3"),
    ;
    private final Integer order;
    private final String typeName;

    /**
     * @return {@link DemoEnum}
     */
    public static DemoEnum randomGetEnum() {
        long seed = Instant.now().getEpochSecond();
        Random random = new Random(seed);

        DemoEnum[] iDemoEnums = DemoEnum.values();
        return iDemoEnums[random.nextInt(iDemoEnums.length)];
    }

    /**
     * 根据类型的名称，返回类型的枚举实例。
     *
     * @param typeName 类型名称
     * @return {@link DemoEnum}
     */
    public static DemoEnum getEnumByName(String typeName) {
        DemoEnum demoEnum = null;
        for (DemoEnum value : DemoEnum.values()) {
            if (value.getTypeName().equals(typeName)) {
                demoEnum = value;
                break;
            }
        }
        return demoEnum;
    }
}
