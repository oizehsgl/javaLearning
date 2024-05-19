package org.oizehsgl.javaLearning.library.gson.util;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import lombok.Builder;
import lombok.Data;

/**
 * 示例过滤策略
 *
 * @author oizehsgl
 */
@Data
@Builder
public class DemoExclusionStrategy implements ExclusionStrategy {

  @Override
  public boolean shouldSkipField(FieldAttributes fieldAttributes) {
    return false;
  }

  @Override
  public boolean shouldSkipClass(Class<?> aClass) {
    return false;
  }
}
