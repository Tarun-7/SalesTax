package Test;

import Main.Domain.Product;
import Main.Domain.ShoppingBasketItem;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingBasketItemTest {

    Product p = new Product();
    ShoppingBasketItem item = new ShoppingBasketItem(p,3,new BigDecimal("5.5"),new BigDecimal("10.5"));

    @Test
    void getQuantity() {
        assertEquals(3, item.getQuantity());
    }

    @Test
    void setQuantity() {
        item.setQuantity(5);
        assertEquals(5, item.getQuantity());
    }

    @Test
    void getTax() {
        assertEquals(new BigDecimal("5.5"), item.getTax());
    }

    @Test
    void setTax() {
        item.setTax(new BigDecimal("33.3"));
        assertEquals(new BigDecimal("33.3"), item.getTax());
    }

    @Test
    void getCost() {
        assertEquals(new BigDecimal("10.5"), item.getCost());
    }

    @Test
    void setCost() {
        item.setCost(new BigDecimal("55.3"));
        assertEquals(new BigDecimal("55.3"), item.getCost());
    }
}