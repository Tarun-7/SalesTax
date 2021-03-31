package Main.Service;

import Main.Domain.Product;
import Main.Domain.ShoppingBasketItem;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BasicSalesTax implements SalesTaxCalculator {

    private BigDecimal tax_rate = new BigDecimal("0.1");
    BigDecimal roundOff_to = new BigDecimal("20");


    @Override
    public void CalculateSalesTax(ShoppingBasketItem shoppingBasketItem){

        Product product = shoppingBasketItem.getProduct();

        shoppingBasketItem.setTax((product.getPrice().multiply(tax_rate)).divide(roundOff_to,10, RoundingMode.HALF_UP).multiply(roundOff_to).setScale(2,RoundingMode.HALF_UP));

        shoppingBasketItem.setCost(product.getPrice().add(shoppingBasketItem.getTax()).setScale(2,RoundingMode.HALF_UP));
    }
}
