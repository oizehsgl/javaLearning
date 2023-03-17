package org.oizehsgl.sub;

import java.util.ArrayList;
import java.util.List;

/**
 * broker
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class Broker {
    private List<Order> orderList = new ArrayList<>();

    public void addOrder(Order order) {
        orderList.add(order);
    }

    public void executeOrderList() {
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
