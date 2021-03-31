package Main;

import Main.Domain.ShoppingBasket;
import Main.Service.TaxCalculatorService;
import Main.Service.ReceiptService;
import Main.Service.InputParser;

public class Main {

    public static void main(String[] args) {

        String[] inputFiles = {"Input1.txt", "Input2.txt", "Input3.txt"};

        for (int i=0; i < inputFiles.length; i++) {

            System.out.println("Output " + (i+1) + ':');

            InputParser input = new InputParser();
            ShoppingBasket shoppingBasket = input.Parser(inputFiles[i]);

            TaxCalculatorService t =  new TaxCalculatorService();
            t.CalculateTaxes(shoppingBasket);

            ReceiptService r = new ReceiptService();
            r.PrintReceipt(shoppingBasket);
        }

    }
}
