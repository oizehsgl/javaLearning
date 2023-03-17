package org.oizehsgl.sub;

/**
 * buyStockOrder
 *
 * @author oizehsgl
 * @since 3/17/23
 */
public class BuyStockOrder implements Order{
    private Stock stock;

    public BuyStockOrder(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
