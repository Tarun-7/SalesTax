package Main.Service;

import Main.Domain.Product;
import Main.Domain.ShoppingBasket;
import Main.Domain.ShoppingBasketItem;

public class ReceiptService {

    // Prints the Receipt
    public void PrintReceipt(ShoppingBasket shoppingBasket) {

        for (int i = 0; i < shoppingBasket.getBasketItems().size(); i++) {

            ShoppingBasketItem item = shoppingBasket.getBasketItems().get(i);
            Product product = item.getProduct();

            System.out.println(item.getQuantity() + product.getName() + ": " + item.getCost());
        }

        System.out.println("Sales Taxes: " + shoppingBasket.getTotalTax());
        System.out.println("Total: " + shoppingBasket.getTotalCost());
    }
}
