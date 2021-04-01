package Main.Service;

import Main.Domain.Product;
import Main.Domain.ShoppingBasket;
import Main.Domain.ShoppingBasketItem;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class InputParser {


    Scanner input = new Scanner(System.in);

    ArrayList<ShoppingBasketItem> shoppingBasketItemsList = new ArrayList<ShoppingBasketItem>();

        public ShoppingBasket Parser(String inputFileName) {

            try {

                File file = new File(inputFileName);
                input = new Scanner(file);

                while (input.hasNextLine()) {

                    String line = input.nextLine();
                    String[] words = line.split(" ");
                    int index = line.lastIndexOf("at");

                    String name = line.substring(1, index); // Scanning name from input.

                    double tmp = Double.parseDouble(line.substring(index+2));
                    BigDecimal price = new BigDecimal(tmp);    // Scanning price from input

                    int quantity = Integer.parseInt(words[0]); // Scanning quantity from input

                    boolean isImported = line.contains("imported"); // setting import status

                    boolean isExempted = false; // default Tax exemption status


                    Product product = new Product(name, price, isImported, isExempted); // Creating Product Object
                    ShoppingBasketItem shoppingBasketItem = new ShoppingBasketItem(product, quantity, BigDecimal.ZERO, BigDecimal.ZERO); // Creating ShoppingBasketItem Object
                    shoppingBasketItemsList.add(shoppingBasketItem);
                }

            } catch (Exception ex)
            {
                ex.printStackTrace();
            }

            ShoppingBasket shoppingBasket = new ShoppingBasket(shoppingBasketItemsList);

            return shoppingBasket;
        }
    }
