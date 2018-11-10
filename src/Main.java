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
            System.out.println("4.- Print Products in the store");
            System.out.println("5.- Print Fresh Products in the store");
            System.out.println("6.- Add Product to Basket");
            System.out.println("7.- Remove product from basket");
            System.out.println("8.- Print Products in the basket");
            System.out.println("9.- Total price of the basket");
            System.out.println("10.- Request Fresh Product");
            System.out.println("11.- Serve Next Request");
            System.out.println("12.- Print Unserved Request");
            System.out.println("13.- Exit");
            try {
                option = Integer.parseInt(bufferedReader.readLine());
                switch (option) {
                    case 1:
                        groceryStore.fillInformationNewClient();
                        break;
                    case 2:
                        groceryStore.fillInformationNewProduct(0);
                        break;
                    case 3:
                        groceryStore.fillInformationNewProduct(1);
                        break;
                    case 4:
                        groceryStore.printStoreProducts();
                        break;
                    case 5:
                        groceryStore.printStoreFreshProducts();
                        break;
                    case 6:
                        groceryStore.informationToAddOrRemoveProducts(0);
                        break;
                    case 7:
                        groceryStore.informationToAddOrRemoveProducts(1);
                        break;
                    case 8:
                        groceryStore.printOrComputeForClient(0);
                        break;
                    case 9:
                        groceryStore.printOrComputeForClient(1);
                        break;
                    case 10:
                        groceryStore.fillInformationAddFreshProduct();
                        break;
                    case 11:
                        groceryStore.serveNextRequest();
                        break;
                    case 12:
                        groceryStore.printUnservedRequests();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: The value entered is not a valid option");
            }
        } while (option != 13);
    }
}
