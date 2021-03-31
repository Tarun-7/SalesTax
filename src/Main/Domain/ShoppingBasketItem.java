package Main.Domain;

import java.math.BigDecimal;

public class ShoppingBasketItem {

    private Product product;
    private int quantity;
    private BigDecimal tax;
    private BigDecimal cost;

    public ShoppingBasketItem() {

    }

    public ShoppingBasketItem(Product product, int quantity, BigDecimal tax, BigDecimal cost) {
        this.product = product;
        this.quantity = quantity;
        this.tax = tax;
        this.cost = cost;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }


}
