package org.oizehsgl.sub;

import org.junit.Test;

/**
 * commandTest
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class CommandTest {
    @Test
    public void testCommand(){
        Stock stock = new Stock();
        BuyStockOrder buyStockOrder = new BuyStockOrder(stock);
        SellStockOrder sellStockOrder = new SellStockOrder(stock);
        Broker broker = new Broker();
        broker.addOrder(buyStockOrder);
        broker.addOrder(sellStockOrder);
        broker.executeOrderList();
    }
}
