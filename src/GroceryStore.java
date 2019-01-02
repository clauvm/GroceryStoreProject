/*Claudia Vaquera*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class GroceryStore implements GroceryStoreInterface {

    private Dictionary storeProductsList;
    private Dictionary clientsList;
    private LinkedList departmentList;
    private int idClient;
    private Queue requestingFreshList;

    public GroceryStore() {
        this.clientsList = new Dictionary();
        this.idClient = 0;
        this.requestingFreshList = new Queue();
        this.departmentList = new LinkedList();
        this.storeProductsList = new Dictionary();
    }

    public void fillInformationNewDepartment() throws IOException {
        System.out.println("DepartmentName");
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

    public void informationToAddOrRemoveProducts(int type) throws IOException {
        System.out.println("Enter your client id");
        BufferedReader bufferedReaderClientId = new BufferedReader(new InputStreamReader(System.in));
        int clientId = Integer.parseInt(bufferedReaderClientId.readLine());
        System.out.println("Enter the barcode of the product");
        BufferedReader bufferedReaderProductBarcode = new BufferedReader(new InputStreamReader(System.in));
        int productBarcode = Integer.parseInt(bufferedReaderProductBarcode.readLine());
        System.out.println("Enter the number of the packages of the product");
        BufferedReader bufferedReaderQuantityPackages = new BufferedReader(new InputStreamReader(System.in));
        int quantityPackages = Integer.parseInt(bufferedReaderQuantityPackages.readLine());
        if (type == 0) {
            addToBasket(productBarcode, quantityPackages, clientId);
        } else {
            removeFromBasket(productBarcode, quantityPackages, clientId);
        }
    }

    public void fillInformationAddFreshProduct() throws IOException {
        System.out.println("Enter your client id");
        BufferedReader bufferedReaderClientId = new BufferedReader(new InputStreamReader(System.in));
        int clientId = Integer.parseInt(bufferedReaderClientId.readLine());
        System.out.println("Enter the barcode of the product");
        BufferedReader bufferedReaderBarcodeId = new BufferedReader(new InputStreamReader(System.in));
        int barcodeId = Integer.parseInt(bufferedReaderBarcodeId.readLine());
        System.out.println("Enter the amount of the product");
        BufferedReader bufferedReaderAmount = new BufferedReader(new InputStreamReader(System.in));
        float amount = Float.parseFloat(bufferedReaderAmount.readLine());
        requestFreshProduct(barcodeId, amount, clientId);
    }

    public void fillInformationCheckoutAndHistory(int type) throws IOException {
        System.out.println("Enter your client id");
        BufferedReader bufferedReaderClientId = new BufferedReader(new InputStreamReader(System.in));
        int clientId = Integer.parseInt(bufferedReaderClientId.readLine());
        if (type == 0) {
            checkout(clientId);
        } else {
            printShoppingHistory(clientId);
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
            if (product.getIsFreshProduct()) {
                float amount = round((float) product.getAmount(), 2);
                count = String.valueOf(amount);
            } else {
                int amount = (int) product.getAmount();
                count = String.valueOf(amount);
            }
            bill += count + " " + product.getName() + " (unit price " + product.getPrice() + " €) --> Total: " + round(((float) (product.getPrice() * product.getAmount())), 2) + " €" + "\n";
            total += product.getPrice() * product.getAmount();
            if (createList) {
                if (product.getIsFreshProduct()) {
                    client.getHistory().addFreshProduct(product);
                } else {
                    client.getHistory().addItem(product);
                }
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
                            product.getBarcode(),
                            count,
                            false)
            );
            product.setAmount(product.getAmount() - count);
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
        Department newDepartment = new Department(departmentName);
        if (this.departmentList == null || this.departmentList.contains(newDepartment) != 0) {
            this.departmentList.addFirst(newDepartment);
        } else {
            System.out.println("Name: " + departmentName + " is already used, please enter a new name");
        }
    }

    public void checkout(int customerId) {
        printBill(customerId);
    }

    public void printShoppingHistory(int customerId) {
        Client client = (Client) this.clientsList.find(customerId);
        System.out.println(client.getHistory().toString());
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
}
