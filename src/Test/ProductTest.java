package Test;

import Main.Domain.Product;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product p = new Product("Ball",new BigDecimal("20.0"), false, false);

    @org.junit.jupiter.api.Test
    void getName() {
        assertEquals("Ball", p.getName());
    }

    @org.junit.jupiter.api.Test
    void setName() {
        p.setName("NewBall");
        assertEquals("NewBall", p.getName());
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
        assertEquals(new BigDecimal("20.0"), p.getPrice());
    }

    @org.junit.jupiter.api.Test
    void setPrice() {
        p.setPrice(new BigDecimal("30.0"));
        assertEquals(new BigDecimal("30.0"), p.getPrice());
    }

    @org.junit.jupiter.api.Test
    void isImported() {
        assertFalse(p.isImported());
    }

    @org.junit.jupiter.api.Test
    void setImported() {
        p.setImported(true);
        assertTrue(p.isImported());
    }


    @org.junit.jupiter.api.Test
    void isExempted() {
        assertFalse(p.isExempted());
    }

    @org.junit.jupiter.api.Test
    void setExempted() {
        p.setExempted(true);
        assertTrue(p.isExempted());
    }
}