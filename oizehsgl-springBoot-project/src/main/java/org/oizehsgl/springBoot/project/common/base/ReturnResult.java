package org.oizehsgl.springBoot.project.common.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.oizehsgl.springBoot.project.common.constant.ReturnStatus;

/**
 * 返回结果
 *
 * @author oizehsgl
 * @date 2024/01/12
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReturnResult<T> {
  private int code;
  private String message;
  private T data;

  public static <S> ReturnResultBuilder<S> success() {
    return new ReturnResultBuilder<S>()
        .code(ReturnStatus.SUCCESS.getCode())
        .message(ReturnStatus.SUCCESS.getMessage());
  }

  public static <S> ReturnResult<S> success(S data) {
    return new ReturnResultBuilder<S>()
        .code(ReturnStatus.SUCCESS.getCode())
        .message(ReturnStatus.SUCCESS.getMessage())
        .data(data)
        .build();
  }

  public static <S> ReturnResult<S> failure(ReturnStatus returnStatus) {
    return new ReturnResultBuilder<S>()
        .code(returnStatus.getCode())
        .message(returnStatus.getMessage())
        .data(null)
        .build();
  }
}
