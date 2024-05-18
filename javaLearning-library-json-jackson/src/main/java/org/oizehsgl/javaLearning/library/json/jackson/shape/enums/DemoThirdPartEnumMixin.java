package org.oizehsgl.javaLearning.library.json.jackson.shape.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.oizehsgl.javaLearning.library.json.jackson.shape.config.EnumDeserializer;
import org.springframework.boot.jackson.JsonMixin;

import java.util.Arrays;

/**
 * 示例第三方枚举混入类
 *
 * @author oizehsgl
 */

@JsonMixin(DemoThirdPartEnum.class)
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
@JsonDeserialize(using = EnumDeserializer.class)
public abstract class DemoThirdPartEnumMixin {
    @JsonCreator
    public DemoThirdPartEnum getEnum(Integer code) {
        return Arrays.stream(DemoThirdPartEnum.values())
                .filter(e -> e.getCode().equals(code))
                .findFirst()
                .orElse(DemoThirdPartEnum.ONE);
    }
}
