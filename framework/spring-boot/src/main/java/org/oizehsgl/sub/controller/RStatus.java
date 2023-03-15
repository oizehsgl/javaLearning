package org.oizehsgl.sub.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * RStatus
 *
 * @author oizehsgl
 * @since 3/14/23
 */
@Getter
@RequiredArgsConstructor
public enum RStatus {
    // 1xx Informational
    CONTINUE(HttpStatus.CONTINUE),
    SWITCHING_PROTOCOLS(HttpStatus.SWITCHING_PROTOCOLS),
    PROCESSING(HttpStatus.PROCESSING),
    CHECKPOINT(HttpStatus.CHECKPOINT),
    // 2xx Success
    OK(HttpStatus.OK),
    CREATED(HttpStatus.CREATED),
    ACCEPTED(HttpStatus.ACCEPTED),
    NON_AUTHORITATIVE_INFORMATION(HttpStatus.NON_AUTHORITATIVE_INFORMATION),
    NO_CONTENT(HttpStatus.NO_CONTENT),
    RESET_CONTENT(HttpStatus.RESET_CONTENT),
    PARTIAL_CONTENT(HttpStatus.PARTIAL_CONTENT),
    MULTI_STATUS(HttpStatus.MULTI_STATUS),
    ALREADY_REPORTED(HttpStatus.ALREADY_REPORTED),
    IM_USED(HttpStatus.IM_USED),
    // 3xx Redirection
    MULTIPLE_CHOICES(HttpStatus.MULTIPLE_CHOICES),
    MOVED_PERMANENTLY(HttpStatus.MOVED_PERMANENTLY),
    FOUND(HttpStatus.FOUND),
    @Deprecated
    MOVED_TEMPORARILY(HttpStatus.MOVED_TEMPORARILY),
    SEE_OTHER(HttpStatus.SEE_OTHER),
    NOT_MODIFIED(HttpStatus.NOT_MODIFIED),
    @Deprecated
    USE_PROXY(HttpStatus.USE_PROXY),
    TEMPORARY_REDIRECT(HttpStatus.TEMPORARY_REDIRECT),
    PERMANENT_REDIRECT(HttpStatus.PERMANENT_REDIRECT),
    // --- 4xx Client Error ---
    BAD_REQUEST(HttpStatus.BAD_REQUEST),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED),
    PAYMENT_REQUIRED(HttpStatus.PAYMENT_REQUIRED),
    FORBIDDEN(HttpStatus.FORBIDDEN),
    NOT_FOUND(HttpStatus.NOT_FOUND),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED),
    NOT_ACCEPTABLE(HttpStatus.NOT_ACCEPTABLE),
    PROXY_AUTHENTICATION_REQUIRED(HttpStatus.PROXY_AUTHENTICATION_REQUIRED),
    REQUEST_TIMEOUT(HttpStatus.REQUEST_TIMEOUT),
    CONFLICT(HttpStatus.CONFLICT),
    GONE(HttpStatus.GONE),
    LENGTH_REQUIRED(HttpStatus.LENGTH_REQUIRED),
    PRECONDITION_FAILED(HttpStatus.PRECONDITION_FAILED),
    PAYLOAD_TOO_LARGE(HttpStatus.PAYLOAD_TOO_LARGE),
    @Deprecated
    REQUEST_ENTITY_TOO_LARGE(HttpStatus.REQUEST_ENTITY_TOO_LARGE),
    URI_TOO_LONG(HttpStatus.URI_TOO_LONG),
    @Deprecated
    REQUEST_URI_TOO_LONG(HttpStatus.REQUEST_URI_TOO_LONG),
    UNSUPPORTED_MEDIA_TYPE(HttpStatus.UNSUPPORTED_MEDIA_TYPE),
    REQUESTED_RANGE_NOT_SATISFIABLE(HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE),
    EXPECTATION_FAILED(HttpStatus.EXPECTATION_FAILED),
    I_AM_A_TEAPOT(HttpStatus.I_AM_A_TEAPOT),
    @Deprecated
    INSUFFICIENT_SPACE_ON_RESOURCE(HttpStatus.INSUFFICIENT_SPACE_ON_RESOURCE),
    @Deprecated
    METHOD_FAILURE(HttpStatus.METHOD_FAILURE),
    @Deprecated
    DESTINATION_LOCKED(HttpStatus.DESTINATION_LOCKED),
    UNPROCESSABLE_ENTITY(HttpStatus.UNPROCESSABLE_ENTITY),
    LOCKED(HttpStatus.LOCKED),
    FAILED_DEPENDENCY(HttpStatus.FAILED_DEPENDENCY),
    TOO_EARLY(HttpStatus.TOO_EARLY),
    UPGRADE_REQUIRED(HttpStatus.UPGRADE_REQUIRED),
    PRECONDITION_REQUIRED(HttpStatus.PRECONDITION_REQUIRED),
    TOO_MANY_REQUESTS(HttpStatus.TOO_MANY_REQUESTS),
    REQUEST_HEADER_FIELDS_TOO_LARGE(HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE),
    UNAVAILABLE_FOR_LEGAL_REASONS(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS),
    // --- 5xx Server Error ---
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR),
    NOT_IMPLEMENTED(HttpStatus.NOT_IMPLEMENTED),
    BAD_GATEWAY(HttpStatus.BAD_GATEWAY),
    SERVICE_UNAVAILABLE(HttpStatus.SERVICE_UNAVAILABLE),
    GATEWAY_TIMEOUT(HttpStatus.GATEWAY_TIMEOUT),
    HTTP_VERSION_NOT_SUPPORTED(HttpStatus.HTTP_VERSION_NOT_SUPPORTED),
    VARIANT_ALSO_NEGOTIATES(HttpStatus.VARIANT_ALSO_NEGOTIATES),
    INSUFFICIENT_STORAGE(HttpStatus.INSUFFICIENT_STORAGE),
    LOOP_DETECTED(HttpStatus.LOOP_DETECTED),
    BANDWIDTH_LIMIT_EXCEEDED(HttpStatus.BANDWIDTH_LIMIT_EXCEEDED),
    NOT_EXTENDED(HttpStatus.NOT_EXTENDED),
    NETWORK_AUTHENTICATION_REQUIRED(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);

    /**
     * 代码
     */
    private final Integer code;

    /**
     * 描述
     */
    private final String desc;

    /**
     * 根据HttpStatus构造
     *
     * @param httpStatus HttpStatus枚举
     */
    RStatus(HttpStatus httpStatus) {
        code = httpStatus.value();
        desc = httpStatus.getReasonPhrase();
    }

    @Override
    public String toString() {
        return String.format("<%d>[%s]", code, desc);
    }
}
