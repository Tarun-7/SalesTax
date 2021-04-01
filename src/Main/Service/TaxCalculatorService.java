package Main.Service;

import Main.Domain.Product;
import Main.Domain.ShoppingBasket;
import Main.Domain.ShoppingBasketItem;
import Main.Service.decorator.BasicSalesTax;
import Main.Service.decorator.ImportSalesTaxDecorator;
import Main.Service.decorator.SalesTaxCalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TaxCalculatorService {

    private String[] ExemptProducts = new String[] {"book", "chocolate", "pills"};
    private BigDecimal tax_rate = BigDecimal.ZERO;
    private BigDecimal totalTax =  BigDecimal.ZERO;
    private BigDecimal totalCost = BigDecimal.ZERO;

    public void CalculateTaxes(ShoppingBasket shoppingBasket) {

        for (int i=0; i < shoppingBasket.getBasketItems().size(); i++) {

            ShoppingBasketItem item = shoppingBasket.getBasketItems().get(i);
            Product product = item.getProduct();

            // Checking and setting Exempt status of product
            for(int j = 0; j < ExemptProducts.length; j++) {
                if (product.getName().contains(ExemptProducts[j])) {
                    product.setExempted(true);
                }
            }

            if (product.isExempted()){
                item.setTax(tax_rate);
                item.setCost(product.getPrice().setScale(2, RoundingMode.HALF_UP));
            }
            else {
                SalesTaxCalculator basicSalesTax = new BasicSalesTax();
                basicSalesTax.CalculateSalesTax(item);
            }

            if (product.isImported()) {
                SalesTaxCalculator importSalesTax = new ImportSalesTaxDecorator(new BasicSalesTax());
                importSalesTax.CalculateSalesTax(item);
            }

            // Total Tax of ShoppingBasket
            totalTax = totalTax.add(item.getTax());
            shoppingBasket.setTotalTax(totalTax);

            // Total Cost of ShoppingBasket
            totalCost = totalCost.add(item.getCost());
            shoppingBasket.setTotalCost(totalCost);

    }

}

}
