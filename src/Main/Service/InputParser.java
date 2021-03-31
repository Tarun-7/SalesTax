package Main.Service;

import Main.Domain.Product;
import Main.Domain.ShoppingBasket;
import Main.Domain.ShoppingBasketItem;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

                    String name = line.substring(1, index);
                    double tmp = Double.parseDouble(line.substring(index+2));
                    BigDecimal price = new BigDecimal(tmp).setScale(2, RoundingMode.HALF_UP);
                    int quantity = Integer.parseInt(words[0]);
                    boolean isImported = line.contains("imported");

                    String[] ExemptProducts = new String[] {"book", "chocolate", "pills"};
                    boolean isExempted = false;
                    for(int i = 0; i<ExemptProducts.length; i++){
                        if(line.contains(ExemptProducts[i])){
                            isExempted = true;
                        }
                    }

                    Product product = new Product(name, price, isImported, isExempted);
                    ShoppingBasketItem shoppingBasketItem = new ShoppingBasketItem(product, quantity, BigDecimal.ZERO, BigDecimal.ZERO);
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
