package Main.Service;

import Main.Domain.Product;
import Main.Domain.ShoppingBasket;
import Main.Domain.ShoppingBasketItem;

import java.math.BigDecimal;

public class TaxCalculatorService {

    private BigDecimal tax_rate = BigDecimal.ZERO;
    private BigDecimal totalTax =  BigDecimal.ZERO;
    private BigDecimal totalCost = BigDecimal.ZERO;

    public void CalculateTaxes(ShoppingBasket shoppingBasket) {

        for (int i=0; i < shoppingBasket.basketItems.size(); i++) {

            ShoppingBasketItem item = shoppingBasket.basketItems.get(i);
            Product product = item.getProduct();

            if (product.isExempted()){
                item.setTax(tax_rate);
                item.setCost(product.getPrice());
            }
            else {
                SalesTaxCalculator basicSalesTax = new BasicSalesTax();
                basicSalesTax.CalculateSalesTax(item);
            }

            if (product.isImported()) {
                SalesTaxCalculator importSalesTax = new ImportSalesTaxDecorator(new BasicSalesTax());
                importSalesTax.CalculateSalesTax(item);
            }

            totalTax = totalTax.add(item.getTax());
            shoppingBasket.setTotalTax(totalTax);

            totalCost = totalCost.add(item.getCost());
            shoppingBasket.setTotalCost(totalCost);

    }

}

}
