package org.oizehsgl.javaLearning.library.json.jackson.shape.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.oizehsgl.javaLearning.library.json.jackson.shape.config.EnumDeserializer;
import org.oizehsgl.javaLearning.library.json.jackson.shape.enums.DemoEnum;
import org.oizehsgl.javaLearning.library.json.jackson.shape.enums.DemoThirdPartEnum;

/**
 * 示例vo
 *
 * @author yueyuanzhi
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DemoVo {
    private DemoEnum demoEnum;
    //@JsonDeserialize(using = EnumDeserializer.class)
    @JsonDeserialize(using = EnumDeserializer.class)
    private DemoThirdPartEnum demoThirdPartEnum;
}
