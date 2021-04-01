package Main.Service.decorator;

import Main.Domain.ShoppingBasketItem;

// Abstract decorator class implementing SalesTaxCalculator Interface
public abstract class SalesTaxDecorator implements SalesTaxCalculator {

    protected SalesTaxCalculator decoratedSalesTax;

    public SalesTaxDecorator(SalesTaxCalculator decoratedSalesTax) {
        this.decoratedSalesTax = decoratedSalesTax;
    }

    public void CalculateSalesTax(ShoppingBasketItem shoppingBasket){
        decoratedSalesTax.CalculateSalesTax(shoppingBasket);
    }
}
