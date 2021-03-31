package Main.Service;

import Main.Domain.ShoppingBasketItem;

public abstract class SalesTaxDecorator implements SalesTaxCalculator {

    protected SalesTaxCalculator decoratedSalesTax;

    public SalesTaxDecorator(SalesTaxCalculator decoratedSalesTax) {
        this.decoratedSalesTax = decoratedSalesTax;
    }

    public void CalculateSalesTax(ShoppingBasketItem shoppingBasket){
        decoratedSalesTax.CalculateSalesTax(shoppingBasket);
    }
}
