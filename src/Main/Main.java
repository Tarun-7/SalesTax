package Main;

import Main.Domain.ShoppingBasket;
import Main.Service.ReceiptService;
import Main.Service.InputParser;
import Main.Service.TaxCalculatorService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        String[] inputFiles = {"Input1.txt", "Input2.txt", "Input3.txt"};

        // Printing Input files
        for (int i=0; i < inputFiles.length; i++) {

            System.out.println( "\nInput " + (i+1) + ':');

            try (BufferedReader br = new BufferedReader(new FileReader(inputFiles[i]))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Processing Input
        for (int i=0; i < inputFiles.length; i++) {

            System.out.println("\nOutput " + (i+1) + ':');

            InputParser input = new InputParser();
            ShoppingBasket shoppingBasket = input.Parser(inputFiles[i]); // Scans input files and returns ShoppingBasket Object

            TaxCalculatorService t =  new TaxCalculatorService();
            t.CalculateTaxes(shoppingBasket); //Calculates Taxes

            ReceiptService r = new ReceiptService();
            r.PrintReceipt(shoppingBasket);  // Prints Receipts
        }

    }
}
