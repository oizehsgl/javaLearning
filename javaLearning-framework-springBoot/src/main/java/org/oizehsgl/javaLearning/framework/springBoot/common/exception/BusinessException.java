package org.oizehsgl.javaLearning.framework.springBoot.common.exception;

import java.io.Serial;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

/**
 * 业务异常
 *
 * @author oizehsgl
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException {
  @Serial private static final long serialVersionUID = 3884525120967869973L;
  private String code;
  private String message;
}
