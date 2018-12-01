/*Claudia Vaquera */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        GroceryStore groceryStore = new GroceryStore();

        groceryStore.addDepartment("Dairy Products");
        groceryStore.addDepartment("Fruits");
        groceryStore.addDepartment("Cookies");
        groceryStore.addClient("Claudia");
        groceryStore.addClient("Hugo");
        groceryStore.addClient("Katty");
        groceryStore.addProduct("Dairy Products", "Milk", 0.89f, 123, 10);
        groceryStore.addProduct("Fruits", "Oranges", 1.48f, 234, 12);
        groceryStore.addProduct("Cookies", "Qkies chocolate", 2.5f, 345, 15);
        groceryStore.addProduct("Fruits", "Apples", 1.05f, 456, 20);
        groceryStore.addProduct("Dairy Products", "Cecemel", 1.69f, 567, 27);
        groceryStore.addFreshProduct("Chicken", 15.45f, 987, 9.5f);
        groceryStore.addFreshProduct("Chicken wings", 17.5f, 876, 8.55f);
        groceryStore.addFreshProduct("Beef steak", 14.3f, 765, 10.85f);
        groceryStore.addFreshProduct("Filet", 14.75f, 654, 15.95f);

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int option = 0;

        do {

            System.out.println("WELCOME choose an option:");
            System.out.println("1.- Add department");
            System.out.println("2.- Add client");
            System.out.println("3.- Add Product");
            System.out.println("4.- Add Fresh Product");
            System.out.println("5.- Print Products in the store");
            System.out.println("6.- Print Fresh Products in the store");
            System.out.println("7.- Add Product to Basket");
            System.out.println("8.- Remove product from basket");
            System.out.println("9.- Print Products in the basket");
            System.out.println("10.- Total price of the basket");
            System.out.println("11.- Request Fresh Product");
            System.out.println("12.- Serve Next Request");
            System.out.println("13.- Print Unserved Request");
            System.out.println("14.- Exit");
            try {
                option = Integer.parseInt(bufferedReader.readLine());
                switch (option) {
                    case 1:
                        groceryStore.fillInformationNewDepartment();
                        break;
                    case 2:
                        groceryStore.fillInformationNewClient();
                        break;
                    case 3:
                        groceryStore.fillInformationNewProduct(0);
                        break;
                    case 4:
                        groceryStore.fillInformationNewProduct(1);
                        break;
                    case 5:
                        groceryStore.printStoreProducts();
                        break;
                    case 6:
                        groceryStore.printStoreFreshProducts();
                        break;
                    case 7:
                        groceryStore.informationToAddOrRemoveProducts(0);
                        break;
                    case 8:
                        groceryStore.informationToAddOrRemoveProducts(1);
                        break;
                    case 9:
                        groceryStore.printOrComputeForClient(0);
                        break;
                    case 10:
                        groceryStore.printOrComputeForClient(1);
                        break;
                    case 11:
                        groceryStore.fillInformationAddFreshProduct();
                        break;
                    case 12:
                        groceryStore.serveNextRequest();
                        break;
                    case 13:
                        groceryStore.printUnservedRequests();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: The value entered is not a valid option");
            }
        } while (option != 14);
    }
}
