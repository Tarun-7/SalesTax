package Main.Domain;

import java.math.BigDecimal;

public class Product {

    private String name;
    private BigDecimal price;
    private boolean isImported;
    private boolean isExempted;

    public Product() {

    }

    public Product(String name, BigDecimal price, boolean isImported, boolean isExempted) {
        this.name = name;
        this.price = price;
        this.isImported = isImported;
        this.isExempted = isExempted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }

    public boolean isExempted() {
        return isExempted;
    }

    public void setExempted(boolean exempted) {
        isExempted = exempted;
    }

}
