package org.oizehsgl.sub;

/**
 * sellStockOrder
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class SellStockOrder implements Order{
    private Stock stock;

    public SellStockOrder(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}
