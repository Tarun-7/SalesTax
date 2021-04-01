package Main.Service.decorator;

import Main.Domain.Product;
import Main.Domain.ShoppingBasketItem;
import java.math.BigDecimal;
import java.math.RoundingMode;

// Concrete Class implementing SalesTaxCalculator Interface
public class BasicSalesTax implements SalesTaxCalculator {

    private BigDecimal tax_rate = new BigDecimal("0.1"); // Set Basic sales tax rate

    @Override
    public void CalculateSalesTax(ShoppingBasketItem shoppingBasketItem){

        Product product = shoppingBasketItem.getProduct();

        //Set Tax = Price  * SalesTaxRate and rounding to nearest 5 cents.
        shoppingBasketItem.setTax((product.getPrice().multiply(tax_rate)).divide(new BigDecimal("20"),10, RoundingMode.HALF_UP).multiply(new BigDecimal("20")).setScale(2,RoundingMode.HALF_UP));

        //Set Cost = Price + Tax
        shoppingBasketItem.setCost(product.getPrice().add(shoppingBasketItem.getTax()).setScale(2,RoundingMode.HALF_UP));
    }
}
