package org.oizehsgl.sub.controller;

import lombok.Getter;

/**
 * businessException
 *
 * @author oizehsgl
 * @since 3/14/23
 */
@Getter
public class BusinessException extends RuntimeException {
    /**
     * 返回状态
     */
    private RStatus rStatus;

    /**
     * 构造方法
     *
     * @param rStatus 返回状态
     */
    public BusinessException(RStatus rStatus) {
        super(rStatus.toString());
        this.rStatus = rStatus;
    }

    /**
     * 构造方法
     *
     * @param rStatus 返回状态
     * @param cause   异常起因
     */
    public BusinessException(RStatus rStatus, Throwable cause) {
        super(rStatus.toString(), cause);
        this.rStatus = rStatus;
    }
}
