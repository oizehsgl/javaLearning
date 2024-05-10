package org.oizehsgl.javaLearning.library.gson.util;

import com.google.gson.InstanceCreator;
import org.oizehsgl.javaLearning.library.gson.DemoNoNoArgsConstructorDto;

import java.lang.reflect.Type;

/**
 * 示例实例创建器
 *
 * @author yueyuanzhi
 */
public class DemoInstanceCreator implements InstanceCreator<DemoNoNoArgsConstructorDto> {
    @Override
    public DemoNoNoArgsConstructorDto createInstance(Type type) {
        return DemoNoNoArgsConstructorDto.builder()
                .build();
    }
}
