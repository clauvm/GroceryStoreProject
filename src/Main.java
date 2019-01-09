/*Claudia Vaquera */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        GroceryStore groceryStore = new GroceryStore();

        groceryStore.addDepartment("Entry");
        groceryStore.addDepartment("Exit");
        groceryStore.addDepartment("Dairy Products");
        groceryStore.addDepartment("Fruits");
        groceryStore.addDepartment("Cookies");

        groceryStore.addDepartment("A");
        groceryStore.addDepartment("B");
        groceryStore.addDepartment("C");
        groceryStore.addDepartment("D");
        groceryStore.addDepartment("E");
        groceryStore.addDepartment("F");
        groceryStore.addDepartment("G");
        groceryStore.addDepartment("H");
        groceryStore.addDepartment("I");
        groceryStore.addDepartment("J");
        groceryStore.addDepartment("K");
        groceryStore.addDepartment("L");
        groceryStore.addDepartment("M");
        groceryStore.addDepartment("N");
        groceryStore.addDepartment("Z");

        groceryStore.connectDepartments("A", "B");
        groceryStore.connectDepartments("A", "C");
        groceryStore.connectDepartments("B", "D");
        groceryStore.connectDepartments("C", "E");
        groceryStore.connectDepartments("C", "F");
        groceryStore.connectDepartments("D", "G");
        groceryStore.connectDepartments("E", "K");
        groceryStore.connectDepartments("E", "H");
        groceryStore.connectDepartments("E", "I");
        groceryStore.connectDepartments("F", "I");
        groceryStore.connectDepartments("F", "J");
        groceryStore.connectDepartments("G", "H");
        groceryStore.connectDepartments("G", "K");
        groceryStore.connectDepartments("I", "L");
//        groceryStore.connectDepartments("J", "K");
        groceryStore.connectDepartments("K", "M");
        groceryStore.connectDepartments("K", "N");
        groceryStore.connectDepartments("L", "Z");
        groceryStore.connectDepartments("M", "Z");
        groceryStore.connectDepartments("N", "Z");
        groceryStore.connectDepartments("I", "N");

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
            System.out.println("2.- Connect departments");
            System.out.println("3.- Print shortest path between two departments");
            System.out.println("4.- Add client");
            System.out.println("5.- Add Product");
            System.out.println("6.- Add Fresh Product");
            System.out.println("7.- Print Products in the store");
            System.out.println("8.- Add product to shopping list");
            System.out.println("9.- Clear shopping list");
            System.out.println("10.- Print optimal path");
            System.out.println("11.- Add Product to Basket");
            System.out.println("12.- Remove product from basket");
            System.out.println("13.- Print Products in the basket");
            System.out.println("14.- Total price of the basket");
            System.out.println("15.- Request Fresh Product");
            System.out.println("16.- Serve Next Request");
            System.out.println("17.- Print Unserved Request");
            System.out.println("18.- Checkout");
            System.out.println("19.- Print Shopping History");
            //additional functionality
            System.out.println("20.- Print Shopping List");
            System.out.println("21.- Print Departments Connections");
            System.out.println("22.- Exit");
            try {
                option = Integer.parseInt(bufferedReader.readLine());
                switch (option) {
                    case 1:
                        groceryStore.fillInformationNewDepartment();
                        break;
                    case 2:
                        groceryStore.fillInformationTwoDepartments(0);
                        break;
                    case 3:
                        groceryStore.fillInformationTwoDepartments(1);
                        break;
                    case 4:
                        groceryStore.fillInformationNewClient();
                        break;
                    case 5:
                        groceryStore.fillInformationNewProduct(0);
                        break;
                    case 6:
                        groceryStore.fillInformationNewProduct(1);
                        break;
                    case 7:
                        groceryStore.printStoreProducts();
                        break;
                    case 8:
                        groceryStore.fillInformationToAddOrRemoveProducts(3);
                        break;
                    case 9:
                        groceryStore.requestClientId(2);
                        break;
                    case 10:
                        groceryStore.requestClientId(3);
                        break;
                    case 11:
                        groceryStore.fillInformationToAddOrRemoveProducts(0);
                        break;
                    case 12:
                        groceryStore.fillInformationToAddOrRemoveProducts(1);
                        break;
                    case 13:
                        groceryStore.printOrComputeForClient(0);
                        break;
                    case 14:
                        groceryStore.printOrComputeForClient(1);
                        break;
                    case 15:
                        groceryStore.fillInformationToAddOrRemoveProducts(2);
                        break;
                    case 16:
                        groceryStore.serveNextRequest();
                        break;
                    case 17:
                        groceryStore.printUnservedRequests();
                        break;
                    case 18:
                        groceryStore.requestClientId(0);
                        break;
                    case 19:
                        groceryStore.requestClientId(1);
                        break;
                    case 20:
                        groceryStore.requestClientId(4);
                        break;
                    case 21:
                        groceryStore.printDepartmentsConnections();
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: The value entered is not a valid option");
            }
        } while (option != 22);
    }
}
