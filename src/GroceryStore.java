/*Claudia Vaquera*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class GroceryStore implements GroceryStoreInterface {

    private Dictionary storeProductsList;
    private Dictionary clientsList;
    private int idClient;
    private Queue requestingFreshList;
    private Graph groceryFloor;

    public GroceryStore() {
        this.clientsList = new Dictionary();
        this.idClient = 0;
        this.requestingFreshList = new Queue();
        this.storeProductsList = new Dictionary();
        this.groceryFloor = new Graph();
    }

    public void fillInformationNewDepartment() throws IOException {
        System.out.println("Department name?");
        BufferedReader bufferedReaderName = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReaderName.readLine();
        addDepartment(name);
    }

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

        if (type == 0) {
            System.out.println("Product quantity?");
            BufferedReader bufferedReaderQuantity = new BufferedReader(new InputStreamReader(System.in));
            int quantity = Integer.parseInt(bufferedReaderQuantity.readLine());

            System.out.println("Product department?");
            BufferedReader bufferedReaderDepartment = new BufferedReader(new InputStreamReader(System.in));
            String department = bufferedReaderDepartment.readLine();

            addProduct(department, name, price, barcode, quantity);
        } else {
            System.out.println("Product amount in kg?");
            BufferedReader bufferedReaderAmount = new BufferedReader(new InputStreamReader(System.in));
            float amount = Float.parseFloat(bufferedReaderAmount.readLine());
            addFreshProduct(name, price, barcode, amount);
        }
    }

    public void fillInformationNewClient() throws IOException {
        System.out.println("Client name?");
        BufferedReader bufferedReaderClientName = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReaderClientName.readLine();
        System.out.println("Client id: " + addClient(name));
    }

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
        if (type == 0) {
            addToBasket(productBarcode, (int) amount, clientId);
        } else if (type == 1) {
            removeFromBasket(productBarcode, (int) amount, clientId);
        } else if (type == 2) {
            requestFreshProduct(productBarcode, amount, clientId);
        } else if (type == 3) {
            addToShoppingList(productBarcode, (int) amount, clientId);
        }
    }

    public void requestClientId(int type) throws IOException {
        System.out.println("Enter your client id");
        BufferedReader bufferedReaderClientId = new BufferedReader(new InputStreamReader(System.in));
        int clientId = Integer.parseInt(bufferedReaderClientId.readLine());
        if (type == 0) {
            checkout(clientId);
        } else if (type == 1) {
            printShoppingHistory(clientId);
        } else if (type == 2) {
            clearShoppingList(clientId);
        } else if (type == 3) {
            printsOptimalPath(clientId);
        } else {
            printShoppingList(clientId);
        }
    }

    public void fillInformationTwoDepartments(int type) throws IOException {
        System.out.println("Name Department 1");
        BufferedReader bufferedReaderDepartment1 = new BufferedReader(new InputStreamReader(System.in));
        String department1 = bufferedReaderDepartment1.readLine();
        System.out.println("Name Department 2");
        BufferedReader bufferedReaderDepartment2 = new BufferedReader(new InputStreamReader(System.in));
        String department2 = bufferedReaderDepartment2.readLine();
        if (type == 0) {
            connectDepartments(department1, department2);
        } else {
            shortestPath(department1, department2);
        }
    }

    public boolean validateInformation(int barcodeId, int customerId, Dictionary list) {
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

    public void printStoreProducts() {
        System.out.println(getProductList());
    }

    public void printOrComputeForClient(int type) throws IOException {
        System.out.println("Client id?");
        BufferedReader bufferedReaderClientId = new BufferedReader(new InputStreamReader(System.in));
        int clientId = Integer.parseInt(bufferedReaderClientId.readLine());
        if (type == 0) {
            printBasket(clientId);
        } else {
            System.out.println("the total price of the basket is: " + round(computeBasketPrice(clientId), 2) + "€" + "\n");
        }

    }

    public void printBill(int customerId) {
        String[] result = traverseList(customerId, true);
        System.out.println(result[0]);
        System.out.println("Total to pay: " + result[1] + "€" + "\n\n");
    }

    public String[] traverseList(int customerId, boolean createList) {
        Client client = (Client) this.clientsList.find(customerId);
        String[] result = new String[2];
        if (client == null) {
            return null;
        }
        String bill = "";
        float total = 0;
        String count;
        for (int i = 0; i < client.getBasket().getListProducts().size(); i++) {
            Product product = (Product) client.getBasket().getListProducts().get(i);
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

    public void createHistoryClient(Product product, Client client) {
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
     * Add products to grocery store
     */
    public void addProduct(String department, String name, float price, int barcodeId, int count) {
        GenericProduct newGenericProduct = new GenericProduct(department, name, price, barcodeId, count, false);
        this.storeProductsList.add(barcodeId, newGenericProduct);
    }

    public void addFreshProduct(String name, float pricePerKg, int barcodeId, float amountInKg) {
        FreshProduct newFreshProduct = new FreshProduct(name, pricePerKg, barcodeId, amountInKg, true);
        this.storeProductsList.add(barcodeId, newFreshProduct);
    }

    public int addClient(String name) {
        idClient++;
        Client newClient = new Client(name, idClient);
        this.clientsList.add(idClient, newClient);
        return idClient;
    }

    public void addToBasket(int barcodeId, int count, int customerId) {
        Product product = (Product) this.storeProductsList.find(barcodeId);
        if (validateInformation(barcodeId, customerId, this.storeProductsList) && !product.getIsFreshProduct() && product.getAmount() >= count) {
            Client client = (Client) this.clientsList.find(customerId);
            client.getBasket().addProduct(
                    new GenericProduct(product.getDepartment(),
                            product.getName(),
                            product.getPrice(),
                            barcodeId,
                            count,
                            false)
            );
            product.setAmount(product.getAmount() - count);
        } else {
            System.out.println("The product couldn't be added to the basket, please check the information");
        }
    }

    public void removeFromBasket(int barcodeId, int count, int customerId) {
        Client client = (Client) this.clientsList.find(customerId);
        Product product = (Product) client.getBasket().getListProducts().find(barcodeId);
        if (validateInformation(barcodeId, customerId, client.getBasket().getListProducts()) && !product.getIsFreshProduct()) {
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

    public void printBasket(int customerId) {
        Client client = (Client) this.clientsList.find(customerId);
        System.out.println(client.getBasket().getListProducts().toString());
    }

    public float computeBasketPrice(int customerId) {
        float total = Float.valueOf(traverseList(customerId, false)[1]);
        return total;
    }

    public void requestFreshProduct(int barcodeId, float amount, int customerId) {
        Product product = (Product) this.storeProductsList.find(barcodeId);
        if (validateInformation(barcodeId, customerId, this.storeProductsList) && product.getIsFreshProduct()) {
            FreshProductRequested request = new FreshProductRequested(customerId, barcodeId, amount);
            this.requestingFreshList.push(request);
        } else {
            System.out.println("Incorrect barcode, please enter again");
        }
    }

    public boolean serveNextRequest() {
        FreshProductRequested request = (FreshProductRequested) this.requestingFreshList.top();
        int barcode = request.getBarcodeId();
        Product product = (Product) this.storeProductsList.find(barcode);
        if (product.getAmount() >= request.getAmount()) {
            Client client = (Client) this.clientsList.find(request.getCustomerId());
            client.getBasket().addProduct(
                    new FreshProduct(product.getName(),
                            product.getPrice(),
                            product.getBarcode(),
                            request.getAmount(),
                            true)
            );
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

    public void printUnservedRequests() {
        System.out.println(getRequestingFreshList().toString());
    }

    public void addDepartment(String departmentName) {
        this.groceryFloor.addNode(departmentName);
    }

    public void checkout(int customerId) {
        printBill(customerId);
    }

    public void connectDepartments(String department1, String department2) {
        if (department1.equals(department2)) {
            System.out.println("It's not possible to connect a department to itself");
            return;
        }
//        if (department1.equals("Entry") || department2.equals("Exit")) {
//            this.groceryFloor.addEdge((Comparable) department1, (Comparable) department2, 1);
//        } else if (department2.equals("Entry") || department1.equals("Exit")) {
//            this.groceryFloor.addEdge(department2, department1, 1);
//        }
        if (department2.equals("Exit")) {
            this.groceryFloor.addEdge((Comparable) department1, (Comparable) department2, 1);
        } else if (department1.equals("Exit")) {
            this.groceryFloor.addEdge(department2, department1, 1);
        } else {
            this.groceryFloor.addEdge(department1, department2, 1);
            this.groceryFloor.addEdge(department2, department1, 1);
        }

    }

    public void shortestPath(String department1, String department2) {
        Stack path = this.groceryFloor.findPathTwoElements(department1, department2);
        System.out.println("Distance: " + path.pop() + "\n");
        System.out.println("Path: " + path);
    }

    public void printShoppingHistory(int customerId) {
        Client client = (Client) this.clientsList.find(customerId);
        System.out.println(client.getHistory().toString());
    }

    public void addToShoppingList(int barcodeId, int count, int customerId) {
        if (!validateInformation(barcodeId, customerId, this.storeProductsList)) {
            return;
        }
        Client client = (Client) this.clientsList.find(customerId);
        Product product = (Product) this.storeProductsList.find(barcodeId);
        client.getShoppingList().addNewItem(
                new GenericProduct(product.getDepartment(),
                        product.getName(),
                        product.getPrice(),
                        barcodeId,
                        count,
                        false)
        );
    }

    public void clearShoppingList(int customerId) {
        Client client = (Client) this.clientsList.find(customerId);
        client.clearShoppingList();
    }

    public void printsOptimalPath(int customerId) {
        LinkedList customerShoppingList = groupDepartmentsShoppingList(customerId);
        if (customerShoppingList.size() > 0) {
            customerShoppingList.addFirst("Entry");
            customerShoppingList.addLast("Exit");
            System.out.printf("\nPlease follow  this route: \n");
            System.out.println(this.groceryFloor.findPathMultipleElements(customerShoppingList));
        } else {
            System.out.println("The shopping list is empty, please add some products");
        }
    }

    /**
     * Get list of products in the store
     *
     * @return
     */
    public Dictionary getProductList() {
        return storeProductsList;
    }

    public Queue getRequestingFreshList() {
        return requestingFreshList;
    }

    public static float round(float number, int decimalPlace) {
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

    public LinkedList groupDepartmentsShoppingList(int customerId) {
        Client client = (Client) this.clientsList.find(customerId);
        ShoppingListClients clientList = client.getShoppingList();
        LinkedList departmentShoppingList = new LinkedList();
        for (int i = 0; i < clientList.getSize(); i++) {
            Product product = (Product) clientList.getShoppingList().get(i);
            if (departmentShoppingList.contains(product.getDepartment()) == -1) {
                departmentShoppingList.addFirst(product.getDepartment());
            }
        }
        System.out.println("List departments " + departmentShoppingList);
        return departmentShoppingList;
    }

    //Extra functions

    public void printDepartmentsConnections() {
        System.out.println(this.groceryFloor);
    }

    public void printShoppingList(int customerId) {
        Client client = (Client) this.clientsList.find(customerId);
        System.out.println(client.getShoppingList().toString());
    }
}
