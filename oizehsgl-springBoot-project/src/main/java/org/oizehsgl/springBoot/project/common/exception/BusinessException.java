package org.oizehsgl.springBoot.project.common.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serial;

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
