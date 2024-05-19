package org.oizehsgl.javaLearning.library.gson.util;

import com.google.gson.InstanceCreator;
import java.lang.reflect.Type;
import org.oizehsgl.javaLearning.library.gson.DemoNoNoArgsConstructorDto;

/**
 * 示例实例创建器
 *
 * @author oizehsgl
 */
public class DemoInstanceCreator implements InstanceCreator<DemoNoNoArgsConstructorDto> {
  @Override
  public DemoNoNoArgsConstructorDto createInstance(Type type) {
    return DemoNoNoArgsConstructorDto.builder().build();
  }
}
