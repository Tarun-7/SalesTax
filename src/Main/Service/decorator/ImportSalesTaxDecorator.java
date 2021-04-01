package Main.Service.decorator;

import Main.Domain.Product;
import Main.Domain.ShoppingBasketItem;
import java.math.BigDecimal;
import java.math.RoundingMode;

// Concrete decorator class extending the SalesTaxDecorator Class
public class ImportSalesTaxDecorator extends SalesTaxDecorator {

    private BigDecimal tax_rate = new BigDecimal("0.05"); // Set import tax rate

    public ImportSalesTaxDecorator(SalesTaxCalculator decoratedSalesTax) {

        super(decoratedSalesTax);
    }

    @Override
    public void CalculateSalesTax(ShoppingBasketItem shoppingBasketItem) {

        Product product = shoppingBasketItem.getProduct();

        //Set Tax = BasicSalesTax + (Price  * ImportTaxRate) and rounding to nearest 5 cents.
        shoppingBasketItem.setTax(new BigDecimal(Math.ceil((shoppingBasketItem.getTax().add((product.getPrice().multiply(tax_rate)))).doubleValue() * 20) / 20).setScale(2, RoundingMode.HALF_UP));

        //Set Cost = Price + Tax
        shoppingBasketItem.setCost(product.getPrice().add(shoppingBasketItem.getTax()).setScale(2,RoundingMode.HALF_UP));

    }
}
