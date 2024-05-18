package org.oizehsgl.javaLearning.library.gson;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * 示例没有无参构造
 *
 * @author oizehsgl
 */
@Data
@Builder
@RequiredArgsConstructor
public class DemoNoNoArgsConstructorDto {
    private final String demo;
}
