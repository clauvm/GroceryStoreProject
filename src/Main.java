/*Claudia Vaquera */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        GroceryStore groceryStore = new GroceryStore();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int option = 0;

        do {

            System.out.println("WELCOME choose an option:");
            System.out.println("1.- Add client");
            System.out.println("2.- Add Product");
            System.out.println("3.- Add Fresh Product");
            System.out.println("4.- Add Product to Basket");
            System.out.println("5.- Remove product from basket");
            System.out.println("6.- Print Products");
            System.out.println("7.- Exit");
            try {
                option = Integer.parseInt(bufferedReader.readLine());
                switch (option) {
                    case 1:
                        groceryStore.fillInformationNewClient();
                        break;
                    case 2:
                        groceryStore.fillInformationNewProduct(1);
                        break;
                    case 3:
                        groceryStore.fillInformationNewProduct(2);
                        break;
                    case 4:
                        //List all products
                        System.out.println(groceryStore.getProductList());
                        System.out.println("Enter the index of the product you want to add");
                        BufferedReader bufferedReaderIndexAdd = new BufferedReader(new InputStreamReader(System.in));
                        int indexAdd = Integer.parseInt(bufferedReaderIndexAdd.readLine());
                        // get the selected product by index
                        int lengthOfProducts = groceryStore.getProductList().size();
                        if (indexAdd <= lengthOfProducts && indexAdd > 0) {
                            Product productToAddToBasket = (Product) groceryStore.getProductList().get(indexAdd - 1);
                            groceryStore.getClient().getBasket().addItem(productToAddToBasket);
                        } else {
                            System.out.println("Invalid index");
                        }
                        break;
                    case 5:
                        System.out.println("Enter the index of the product you want to remove");
                        BufferedReader bufferedReaderIndexRemove = new BufferedReader(new InputStreamReader(System.in));
                        int indexRemove = Integer.parseInt(bufferedReaderIndexRemove.readLine());
                        int lengthBasketProducts = groceryStore.getClient().getBasket().getListProducts().size();
                        if (indexRemove <= lengthBasketProducts && indexRemove > 0) {
                            groceryStore.getClient().getBasket().removeItem(indexRemove - 1);
                        } else {
                            System.out.println("Invalid index");
                        }
                        break;
                    case 6:
                        System.out.println(groceryStore.getClient().getBasket().getListProducts());
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: The value entered is not a valid option");
            }

        } while (option != 6);

    }

}
