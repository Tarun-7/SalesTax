package Main.Domain;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingBasket {


    public List<ShoppingBasketItem> basketItems;
    public BigDecimal totalTax;
    public BigDecimal totalCost;

    public ShoppingBasket(List<ShoppingBasketItem> basketItems) {
        this.basketItems = basketItems;
    }

    public List<ShoppingBasketItem> getBasketItems() {
        return basketItems;
    }

    public void setCartItems(List<ShoppingBasketItem> BasketItems) {
        basketItems = basketItems;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
}
