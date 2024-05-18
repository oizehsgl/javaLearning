package org.oizehsgl.javaLearning.framework.springBoot.common.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 返回状态
 *
 * @author oizehsgl
 */
@Getter
@RequiredArgsConstructor
public enum ReturnStatus {
    SUCCESS(Series.SUCCESSFUL, 2000, "成功!"),
    BODY_NOT_MATCH(Series.CLIENT_ERROR, 4000, "请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH(Series.CLIENT_ERROR, 4001, "请求的数字签名不匹配!"),
    NOT_FOUND(Series.CLIENT_ERROR, 4004, "未找到该资源!"),
    INTERNAL_SERVER_ERROR(Series.SERVER_ERROR, 5000, "服务器内部错误!"),
    SERVER_BUSY(Series.SERVER_ERROR, 5003, "服务器正忙,请稍后再试!");

    /**
     * 返回系列
     *
     * @author oizehsgl
     */
    @RequiredArgsConstructor
    public enum Series {
        INFORMATIONAL(1),
        //成功
        SUCCESSFUL(2),
        REDIRECTION(3),
        //客户端错误
        CLIENT_ERROR(4),
        //服务端错误
        SERVER_ERROR(5);
        private final int code;
    }

    /**
     * 状态系列
     */
    private final Series series;
    /**
     * 返回代码
     */
    private final int code;
    /**
     * 返回信息
     */
    private final String message;

}
