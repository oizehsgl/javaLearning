package org.oizehsgl.javaLearning.framework.springBoot.statemachine.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * 订单事件
 *
 * @author yueyuanzhi
 */
@Getter
@RequiredArgsConstructor
public enum OrderEvent {
    // 支付，发货，确认收货
    PAYED("支付"),
    DELIVERY("发货"),
    RECEIVED("确认收获"),
    ;
    private final String desc;
}
