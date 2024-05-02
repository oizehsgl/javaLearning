package org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 订单状态
 *
 * @author yueyuanzhi
 */
@Getter
@RequiredArgsConstructor
public enum OrderState {
    WAIT_PAYMENT(1, "待支付"),
    WAIT_DELIVER(2, "待发货"),
    WAIT_RECEIVE(3, "待收货"),
    FINISH(4, "已完成"),
    ;
    private final Integer code;
    private final String desc;
}
