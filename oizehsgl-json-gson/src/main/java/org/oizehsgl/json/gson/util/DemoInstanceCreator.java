package org.oizehsgl.json.gson.util;


import com.google.gson.InstanceCreator;
import org.oizehsgl.json.gson.DemoNoNoArgsConstructorDto;

import java.lang.reflect.Type;

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
