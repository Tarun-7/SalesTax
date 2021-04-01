package Main.Service.decorator;

import Main.Domain.ShoppingBasketItem;

// Decorator Design Pattern to Calculate SalesTax
// SalesTaxCalculator Interface
public interface SalesTaxCalculator  {

    void CalculateSalesTax(ShoppingBasketItem shoppingBasket);
}
