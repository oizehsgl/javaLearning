package org.oizehsgl.sub.controller;

import lombok.Builder;
import lombok.Data;

/**
 * r
 *
 * @author oizehsgl
 * @since 3/14/23
 */
@Data
@Builder
public class R<T> {
    /**
     * 响应代码
     */
    private Integer code;

    /**
     * 响应描述
     */
    private String desc;

    /**
     * 响应结果
     */
    private T data;

    /**
     * 响应
     *
     * @param data    返回数据
     * @param rStatus 返回状态
     * @param <T>     返回泛型
     * @return 封装数据
     */
    public static <T> R<T> response(RStatus rStatus, T data) {
        return R.<T>builder().data(data).code(rStatus.getCode()).desc(rStatus.getDesc()).build();
    }

    /**
     * 成功
     *
     * @param rStatus 状态
     * @param data    数据
     * @param <T>     泛型
     * @return 封装数据
     */
    public static <T> R<T> success(RStatus rStatus, T data) {
        return response(rStatus, data);
    }

    public static <T> R<T> success(T data) {
        return success(RStatus.OK, data);
    }

    public static <T> R<T> success(RStatus rStatus) {
        return success(rStatus, null);
    }


    public static <T> R<T> success() {
        return success(null);
    }


    /**
     * 失败
     *
     * @param rStatus 状态
     * @param <T>     泛型
     * @return 封装数据
     */
    public static <T> R<T> failure(RStatus rStatus) {
        return response(rStatus, null);
    }

    public static <T> R<T> failure(BusinessException businessException) {
        return failure(businessException.getRStatus());
    }
}
