/**
 * Grocery store class is the principal class of the project because here it's possible create clients, products, etc.
 * It implements the interface provided in classes.
 * Some methods are important for interaction with the user
 *
 * @author Claudia Vaquera
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class GroceryStore implements GroceryStoreInterface {

    private int idClient;
    private Dictionary clientsList;
    private Dictionary storeProductsList;
    private Queue requestingFreshList;
    private Graph groceryFloor;

    public GroceryStore() {
        this.idClient = 0;
        this.clientsList = new Dictionary();
        this.storeProductsList = new Dictionary();
        this.requestingFreshList = new Queue();
        this.groceryFloor = new Graph();
    }

    /**
     * Asks for the department name, and then redirect it to the addDepartment method
     *
     * @throws IOException required to work with BufferReader
     */
    public void fillInformationNewDepartment() throws IOException {
        System.out.println("Department name?");
        BufferedReader bufferedReaderName = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReaderName.readLine();
        addDepartment(name);
    }

    /**
     * Asks for the details of a new product, since this information is important to add both, a generic product
     * and a fresh product, this method is used in both cases, and a type is passed as a parameter to choose the method
     * where the information will be send
     *
     * @param type int
     * @throws IOException required to work with BufferReader
     */
    public void fillInformationNewProduct(int type) throws IOException {
        System.out.println("Product name?");
        BufferedReader bufferedReaderName = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReaderName.readLine();

        System.out.println("Product price?");
        BufferedReader bufferedReaderPrice = new BufferedReader(new InputStreamReader(System.in));
        float price = Float.parseFloat(bufferedReaderPrice.readLine());

        System.out.println("Product barcode?");
        BufferedReader bufferedReaderBarcode = new BufferedReader(new InputStreamReader(System.in));
        int barcode = Integer.parseInt(bufferedReaderBarcode.readLine());

        if (type == 0) {     // if it's a normal product
            System.out.println("Product quantity?");
            BufferedReader bufferedReaderQuantity = new BufferedReader(new InputStreamReader(System.in));
            int quantity = Integer.parseInt(bufferedReaderQuantity.readLine());

            System.out.println("Product department?");
            BufferedReader bufferedReaderDepartment = new BufferedReader(new InputStreamReader(System.in));
            String department = bufferedReaderDepartment.readLine();

            addProduct(department, name, price, barcode, quantity);
        } else {             // if it's a fresh product
            System.out.println("Product amount in kg?");
            BufferedReader bufferedReaderAmount = new BufferedReader(new InputStreamReader(System.in));
            float amount = Float.parseFloat(bufferedReaderAmount.readLine());
            addFreshProduct(name, price, barcode, amount);
        }
    }

    /**
     * Asks for the client name, and then redirect it to the addClient method
     *
     * @throws IOException required to work with BufferReader
     */
    public void fillInformationNewClient() throws IOException {
        System.out.println("Client name?");
        BufferedReader bufferedReaderClientName = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReaderClientName.readLine();
        System.out.println("Client id: " + addClient(name));
    }

    /**
     * When adding or removing a product, some information needs to be given, like the client id, barcode of the
     * product and amount, so in this case a type is also required as a param to choose the method where all the
     * information will be send
     *
     * @param type int
     * @throws IOException required to work with BufferReader
     */
    public void fillInformationToAddOrRemoveProducts(int type) throws IOException {
        System.out.println("Enter your client id");
        BufferedReader bufferedReaderClientId = new BufferedReader(new InputStreamReader(System.in));
        int clientId = Integer.parseInt(bufferedReaderClientId.readLine());
        System.out.println("Enter the barcode of the product");
        BufferedReader bufferedReaderProductBarcode = new BufferedReader(new InputStreamReader(System.in));
        int productBarcode = Integer.parseInt(bufferedReaderProductBarcode.readLine());
        System.out.println("Enter the number of the packages/amount of the product");
        BufferedReader bufferedReaderAmount = new BufferedReader(new InputStreamReader(System.in));
        float amount = Float.parseFloat(bufferedReaderAmount.readLine());
        if (type == 0) {                // add to the basket
            addToBasket(productBarcode, (int) amount, clientId);
        } else if (type == 1) {         // remove product from basket
            removeFromBasket(productBarcode, (int) amount, clientId);
        } else if (type == 2) {         // request fresh product
            requestFreshProduct(productBarcode, amount, clientId);
        } else if (type == 3) {         // add product to shopping list
            addToShoppingList(productBarcode, (int) amount, clientId);
        }
    }

    /**
     * Some methods require the client id, so in this case a type is also required as a param to choose
     * the method where all the information will be send
     *
     * @param type int
     * @throws IOException required to work with BufferReader
     */
    public void requestClientId(int type) throws IOException {
        System.out.println("Enter your client id");
        BufferedReader bufferedReaderClientId = new BufferedReader(new InputStreamReader(System.in));
        int clientId = Integer.parseInt(bufferedReaderClientId.readLine());
        if (type == 0) {                // client checksout
            checkout(clientId);
        } else if (type == 1) {         // prints shopping list of the client
            printShoppingHistory(clientId);
        } else if (type == 2) {         // clears shopping list
            clearShoppingList(clientId);
        } else if (type == 3) {         // prints optimal path given a shopping list
            printsOptimalPath(clientId);
        } else if (type == 4) {         // prints the basket
            printBasket(clientId);
        } else if (type == 5) {         // prints the price of the basket
            System.out.println("the total price of the basket is: " + round(computeBasketPrice(clientId), 2) + "€" + "\n");
        } else {                        // prints the shopping list
            printShoppingList(clientId);
        }
    }

    /**
     * Two methods require the name of two departments, so this method ask it to the client.
     * Type is also required since two methods depend on this information
     *
     * @param type int
     * @throws IOException required to work with BufferReader
     */
    public void fillInformationTwoDepartments(int type) throws IOException {
        System.out.println("Name Department 1");
        BufferedReader bufferedReaderDepartment1 = new BufferedReader(new InputStreamReader(System.in));
        String department1 = bufferedReaderDepartment1.readLine();
        System.out.println("Name Department 2");
        BufferedReader bufferedReaderDepartment2 = new BufferedReader(new InputStreamReader(System.in));
        String department2 = bufferedReaderDepartment2.readLine();
        if (type == 0) {        // connect two departments
            connectDepartments(department1, department2);
        } else {                // find the shortest path between two departments
            shortestPath(department1, department2);
        }
    }

    /**
     * This method validates a barcode presented in a list and if the client is registered in the grocery store
     *
     * @param barcodeId  int
     * @param customerId int
     * @param list       Dictionary
     * @return result of the validation
     */
    private boolean validateInformation(int barcodeId, int customerId, Dictionary list) {
        if (list.find(barcodeId) == null) {
            System.out.println("The product isn't part of the list, please enter the barcode again ");
            return false;
        }
        if (this.clientsList.find(customerId) == null) {
            System.out.println("Incorrect customer id, please enter the id again");
            return false;
        }
        return true;
    }

    /**
     * Adds a new department in the grocery store
     *
     * @param departmentName - is the name of the department that is added to the store
     */
    public void addDepartment(String departmentName) {
        this.groceryFloor.addNode(departmentName);
    }

    /**
     * Adds a new client, the id is correlative
     *
     * @param name - name of the client
     * @return idClient
     */
    public int addClient(String name) {
        idClient++;
        Client newClient = new Client(name, idClient);
        this.clientsList.add(idClient, newClient);
        return idClient;
    }

    /**
     * Adds products to grocery store
     *
     * @param department - represents a department to which is the product added
     * @param name - represents the name of the new product
     * @param price - represents the price of the new product
     * @param barcodeId - is the barcode number of the new product
     * @param count - is the number of items of the new product in the store
     */
    public void addProduct(String department, String name, float price, int barcodeId, int count) {
        GenericProduct newGenericProduct = new GenericProduct(department, name, price, barcodeId, count, false);
        this.storeProductsList.add(barcodeId, newGenericProduct);
    }

    /**
     * Adds fresh product to grocery store
     *
     * @param name - represents the name of the new fresh product
     * @param pricePerKg - represents the price of the new fresh product
     * @param barcodeId - is the barcode number of the new fresh product
     * @param amountInKg - is the amount in kilograms the new fresh product in the store
     */
    public void addFreshProduct(String name, float pricePerKg, int barcodeId, float amountInKg) {
        FreshProduct newFreshProduct = new FreshProduct(name, pricePerKg, barcodeId, amountInKg, true);
        this.storeProductsList.add(barcodeId, newFreshProduct);
    }

    /**
     * Adds products to the client's shopping list
     *
     * @param barcodeId  - the barcode of the product that is added to the shopping list
     * @param count      - number of the packages of the product that is added to the shopping list
     * @param customerId - the client id that is adding the product to the shopping list
     */
    public void addToShoppingList(int barcodeId, int count, int customerId) {
        if (!validateInformation(barcodeId, customerId, this.storeProductsList)) {
            return;
        }
        Client client = (Client) this.clientsList.find(customerId);
        Product productInStore = (Product) this.storeProductsList.find(barcodeId);
        ProductToShoppingList product = new ProductToShoppingList(
                customerId,
                barcodeId,
                productInStore.getName(),
                count,
                productInStore.getDepartment() != null ? productInStore.getDepartment() : "Fresh Products");
        client.getShoppingList().addNewItem(product);
    }

    /**
     * Adds products to a client's basket
     *
     * @param barcodeId - the barcode of the product that is added to the basket
     * @param count - number of the packages of the product that is added to the basket
     * @param customerId - the client id that is adding the product to the basket
     */
    public void addToBasket(int barcodeId, int count, int customerId) {
        Product product = (Product) this.storeProductsList.find(barcodeId);
        if (validateInformation(barcodeId, customerId, this.storeProductsList)
                && !product.getIsFreshProduct() && product.getAmount() >= count) {
            Client client = (Client) this.clientsList.find(customerId);
            Product productInBasket = (Product) client.getBasket().getListProducts().find(barcodeId);

            /* If the product is currently in the basket, the amount is set to the previous one plus the new one */
            if (productInBasket != null) {
                productInBasket.setAmount(productInBasket.getAmount() + count);
            } else {
                client.getBasket().addProduct(
                        new GenericProduct(product.getDepartment(),
                                product.getName(),
                                product.getPrice(),
                                barcodeId,
                                count,
                                false)
                );
            }

            /* Decrease the amount of the product in the grocery store */
            product.setAmount(product.getAmount() - count);
        } else {
            System.out.println("The product couldn't be added to the basket, please check the information");
        }
    }

    /**
     * A fresh product can't be added directly to the basket, the client needs to request it and wait until
     * the previous requests have been processed
     *
     * @param barcodeId  - the barcode of the fresh product that is requested by the client
     * @param amount     - amount in kilograms that is requested by the client
     * @param customerId - the client id of the client making the request
     */
    public void requestFreshProduct(int barcodeId, float amount, int customerId) {
        Product product = (Product) this.storeProductsList.find(barcodeId);
        if (validateInformation(barcodeId, customerId, this.storeProductsList) && product.getIsFreshProduct()) {
            FreshProductRequested request = new FreshProductRequested(customerId, barcodeId, amount);
            this.requestingFreshList.push(request);
        } else {
            System.out.println("Incorrect barcode, please enter again");
        }
    }

    /**
     * Processes the next request in the queue. If the request can be processed then it adds the product to the basket.
     *
     * @return the result of the process
     */
    public boolean serveNextRequest() {
        FreshProductRequested request = (FreshProductRequested) this.requestingFreshList.top();
        float amount = request.getAmount();
        int barcode = request.getBarcodeId();
        Product product = (Product) this.storeProductsList.find(barcode);
        if (product.getAmount() >= amount) {
            Client client = (Client) this.clientsList.find(request.getCustomerId());
            Product productInBasket = (Product) client.getBasket().getListProducts().find(barcode);

            /* If the product is currently in the basket, the amount is set to the previous one plus the new one */
            if (productInBasket != null) {
                productInBasket.setAmount(productInBasket.getAmount() + amount);
            } else {
                client.getBasket().addProduct(
                        new FreshProduct(product.getName(),
                                product.getPrice(),
                                barcode,
                                amount,
                                true)
                );
            }
            product.setAmount(product.getAmount() - request.getAmount());
            this.requestingFreshList.pop();
            System.out.println("Request successful" + "\n" + request);
            return true;
        } else {
            System.out.println("We don't have the amount in kg you requested");
            this.requestingFreshList.pop();
            return false;
        }
    }

    /**
     * Traverses the products in the client's basket, to compute the amount, and or create the bill
     *
     * @param customerId int
     * @param createList boolean
     * @return bill and total amount to be paid
     */
    private String[] traverseList(int customerId, boolean createList) {
        Client client = (Client) this.clientsList.find(customerId);
        String[] result = new String[]{"", ""};
        if (client == null) {
            return null;
        }
        String bill = "";
        float total = 0;
        String count;
        for (int i = 0; i < client.getBasket().getListProducts().size(); i++) {
            Product product = (Product) client.getBasket().getListProducts().get(i);

            /* People only pay amounts with no more than two decimals, so it's important to round the amount obtained */
            float amount = round((float) product.getAmount(), 2);
            count = String.valueOf(amount);
            bill += count + " " + product.getName() + " (unit price " + product.getPrice() + " €) --> Total: " + round(((float) (product.getPrice() * product.getAmount())), 2) + " €" + "\n";
            total += product.getPrice() * product.getAmount();
            if (createList) {
                createHistoryClient(product, client);
            }
        }
        total = round(total, 2);
        result[0] = bill;
        result[1] = String.valueOf(total);
        if (createList) {
            client.deleteBasket();
        }

        return result;
    }

    /**
     * Remove a product from the basket, a product can only be removed is it's a generic product, if the amount
     * is less than the product quantity in the basket, the amount is set, if the amount is equals to the project
     * quantity, the whole product is removed from the basket, in both cases the amount in the grocery product's list
     * is set to a higher one
     *
     * @param barcodeId - the barcode of the product that is removed from the basket
     * @param count - number of the packages of the product that is removed from the basket
     * @param customerId - the client id that is removing the product from the basket
     */
    public void removeFromBasket(int barcodeId, int count, int customerId) {
        Client client = (Client) this.clientsList.find(customerId);
        Product product = (Product) client.getBasket().getListProducts().find(barcodeId);
        if (validateInformation(barcodeId, customerId, client.getBasket().getListProducts())
                && !product.getIsFreshProduct()) {
            Product productInStore = (Product) this.storeProductsList.find(barcodeId);
            int productQuantity = (int) product.getAmount();
            if (productQuantity > count) {
                product.setAmount(productQuantity - count);
                productInStore.setAmount(productInStore.getAmount() + count);
            } else if (productQuantity == count) {
                client.getBasket().removeItem(barcodeId);
                productInStore.setAmount(productInStore.getAmount() + count);
            } else {
                System.out.println("You only have " + productQuantity + " packages of this products and you want to remove " + count + " please, enter a valid quantity");
            }
        } else {
            System.out.println("You can't remove a fresh product from your basket");
        }
    }

    /**
     * Computes the basket price using the traverse list method
     *
     * @param customerId - the client id whose basket will be printed out
     * @return total price of the basket
     */
    public float computeBasketPrice(int customerId) {
        return Float.valueOf(traverseList(customerId, false)[1]);
    }

    /**
     * Checkouts the items in the basket
     *
     * @param customerId - customer id
     */
    public void checkout(int customerId) {
        printBill(customerId);
    }

    /**
     * Creates the history of purchase of a client
     *
     * @param product Product
     * @param client  Client
     */
    private void createHistoryClient(Product product, Client client) {
        if (product.getIsFreshProduct()) {
            client.getHistory().addNewItem(
                    new FreshProduct(product.getName(),
                            product.getPrice(),
                            product.getBarcode(),
                            (float) product.getAmount(),
                            true)
            );
        } else {
            client.getHistory().addNewItem(
                    new GenericProduct(product.getDepartment(),
                            product.getName(),
                            product.getPrice(),
                            product.getBarcode(),
                            (int) product.getAmount(),
                            false)
            );
        }
    }

    /**
     * Connects two departments, the connection is undirected
     *
     * @param department1 - name of the first department that will be connected.
     * @param department2 - name of the second department that will be connected.
     */
    public void connectDepartments(String department1, String department2) {
        if (department1.equals(department2)) {
            System.out.println("It's not possible to connect a department to itself");
            return;
        }

        /* the following commented code was used to make the Entry and Exit nodes directed, but then it was more
         * convenient that only 'Exit' node be directed
         */
//        if (department1.equals("Entry") || department2.equals("Exit")) {
//            this.groceryFloor.addEdge((Comparable) department1, (Comparable) department2, 1);
//        } else if (department2.equals("Entry") || department1.equals("Exit")) {
//            this.groceryFloor.addEdge(department2, department1, 1);
//        }

        /* the assigned weight, for all edges, is 1, this could have been ignored, but it's possible
         * than in the future the edges need a specific weight, and if all the edges have the same
         * weight it is as if none of them had it
         * */
        if (department2.equals("Exit")) {
            this.groceryFloor.addEdge((Comparable) department1, (Comparable) department2, 1);
        } else if (department1.equals("Exit")) {
            this.groceryFloor.addEdge(department2, department1, 1);
        } else {

            /* this creates undirected edges */
            this.groceryFloor.addEdge(department1, department2, 1);
            this.groceryFloor.addEdge(department2, department1, 1);
        }

    }

    /**
     * This method is used to find th e shortest path between two nodes
     *
     * @param department1 - name of the source department.
     * @param department2 - name of the destination department.
     */
    public void shortestPath(String department1, String department2) {
        Stack path = this.groceryFloor.findPathTwoElements(department1, department2);
        System.out.println("Distance: " + path.pop() + "\n");
        System.out.println("Path: " + path);
    }

    /**
     * Clears shopping list, this method remove all the items in the shopping list
     *
     * @param customerId - the client id for which the shopping list will be deleted.
     */
    public void clearShoppingList(int customerId) {
        Client client = (Client) this.clientsList.find(customerId);
        client.clearShoppingList();
    }

    /**
     * Gets list of products in the store
     *
     * @return list
     */
    public Dictionary getProductList() {
        return storeProductsList;
    }

    /**
     * Gets List of requested fresh products
     *
     * @return list
     */
    private Queue getRequestingFreshList() {
        return requestingFreshList;
    }

    /**
     * The shopping list only has products, so it's important to group them by department, because
     * the list of departments in the shopping list is essential to find the optimal path
     *
     * @param customerId int
     * @return list of departments
     */
    private LinkedList groupDepartmentsShoppingList(int customerId) {
        Client client = (Client) this.clientsList.find(customerId);
        ShoppingListClients clientList = client.getShoppingList();
        LinkedList departmentShoppingList = new LinkedList();
        for (int i = 0; i < clientList.getSize(); i++) {
            ProductToShoppingList product = (ProductToShoppingList) clientList.getShoppingList().get(i);
            if (departmentShoppingList.contains(product.getDepartment()) == -1) {
                departmentShoppingList.addFirst(product.getDepartment());
            }
        }
        System.out.println("List departments " + departmentShoppingList);
        return departmentShoppingList;
    }

    /**
     * Method to round a large float, the desired quantity of decimals is required
     *
     * @param number       float
     * @param decimalPlace int
     * @return number
     */
    private static float round(float number, int decimalPlace) {
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    /**
     * Prints products in the store
     */
    public void printStoreProducts() {
        System.out.println(getProductList());
    }

    /**
     * Prints the bill of a client, it's printed after the checkout, so it's important to create the history client
     *
     * @param customerId int
     */
    public void printBill(int customerId) {
        String[] result = traverseList(customerId, true);
        System.out.println(result[0]);
        System.out.println("Total to pay: " + result[1] + "€" + "\n\n");
    }

    /**
     * Prints the basket of the client
     *
     * @param customerId - the client id whose basket will be printed out
     */
    public void printBasket(int customerId) {
        Client client = (Client) this.clientsList.find(customerId);
        System.out.println(client.getBasket().getListProducts().toString());
    }

    /**
     * Prints unserved fresh products request
     */
    public void printUnservedRequests() {
        System.out.println(getRequestingFreshList().toString());
    }

    /**
     * Prints shopping history
     *
     * @param customerId - the client id for which the shopping history will be printed
     */
    public void printShoppingHistory(int customerId) {
        Client client = (Client) this.clientsList.find(customerId);
        System.out.println(client.getHistory().toString());
    }

    /**
     * Prints the optimal path for the shopping list, this considers the entry node as the starting point
     * and the exit node as the final node
     *
     * @param customerId - the client id for which the optimal path will be obtained.
     */
    public void printsOptimalPath(int customerId) {
        LinkedList customerShoppingList = groupDepartmentsShoppingList(customerId);
        if (customerShoppingList.size() > 0) {
            customerShoppingList.addFirst("Entry");
            customerShoppingList.addLast("Exit");
            System.out.printf("\n Please follow  this route: \n");
            System.out.println(this.groceryFloor.findPathMultipleElements(customerShoppingList));
        } else {
            System.out.println("The shopping list is empty, please add some products");
        }
    }

    /* Extra functions that could be useful*/

    /**
     * Prints department's connections
     */
    public void printDepartmentsConnections() {
        System.out.println(this.groceryFloor);
    }

    /**
     * prints shopping list of a client
     * @param customerId int
     */
    public void printShoppingList(int customerId) {
        Client client = (Client) this.clientsList.find(customerId);
        System.out.println(client.getShoppingList().toString());
    }
}
