package Main.Service;

import Main.Domain.Product;
import Main.Domain.ShoppingBasketItem;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ImportSalesTaxDecorator extends SalesTaxDecorator {

    private BigDecimal tax_rate = new BigDecimal("0.05");
    BigDecimal roundOff_to = new BigDecimal("20");

    public ImportSalesTaxDecorator(SalesTaxCalculator decoratedSalesTax) {

        super(decoratedSalesTax);
    }

    @Override
    public void CalculateSalesTax(ShoppingBasketItem shoppingBasketItem) {

        Product product = shoppingBasketItem.getProduct();

        shoppingBasketItem.setTax((shoppingBasketItem.getTax().add((product.getPrice().multiply(tax_rate)).divide(roundOff_to,2, RoundingMode.HALF_UP).multiply(roundOff_to))));

        shoppingBasketItem.setCost(product.getPrice().add(shoppingBasketItem.getTax()).setScale(2,RoundingMode.HALF_UP));

    }
}
