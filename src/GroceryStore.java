/*Claudia Vaquera*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroceryStore implements GroceryStoreInterface {

    private LinkedList productList;
    private LinkedList freshProductList;
    private LinkedList clientList;
    private int idClient;
    private Queue requestingFreshList;

    public GroceryStore() {
        this.productList = new LinkedList();
        this.freshProductList = new LinkedList();
        this.clientList = new LinkedList();
        this.idClient = 0;
        this.requestingFreshList = new Queue();
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
            addProduct(name, price, barcode, quantity);
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

    public int compareClientId(int id) {
        Client temp = new Client("test", id);
        return clientList.contains(temp);
    }

    public int compareBarcodeId(int barcode, LinkedList list) {
        Product temp = new Product("test", 0, barcode);
        return list.contains(temp);
    }

    public void printStoreProducts() {
        System.out.println(getProductList());
    }

    public void printStoreFreshProducts() {
        System.out.println(getFreshProductList());
    }

    public void printOrComputeForClient(int type) throws IOException {
        System.out.println("Client id?");
        BufferedReader bufferedReaderClientId = new BufferedReader(new InputStreamReader(System.in));
        int clientId = Integer.parseInt(bufferedReaderClientId.readLine());
        if (type == 0) {
            printBasket(clientId);
        } else {
            System.out.println("the total price of the basket is: " + computeBasketPrice(clientId));
        }

    }
    /**
     * Add products to grocery store
     */
    public void addProduct(String name, float price, int barcodeId, int count) {
        GenericProduct newGenericProduct = new GenericProduct(name, price, barcodeId, count);
        this.productList.addFirst(newGenericProduct);
    }

    public void addFreshProduct(String name, float pricePerKg, int barcodeId, float amountInKg) {
        FreshProduct newFreshProduct = new FreshProduct(name, pricePerKg, barcodeId, amountInKg);
        this.freshProductList.addFirst(newFreshProduct);
    }

    public int addClient(String name) {
        idClient++;
        Client newClient = new Client(name, idClient);
        this.clientList.addFirst(newClient);
        return idClient;
    }

    public void addToBasket(int barcodeId, int count, int customerId) {
        int clientIndex = compareClientId(customerId);
        int productIndex = compareBarcodeId(barcodeId, this.productList);
        if (productIndex >= 0) {
            GenericProduct product = (GenericProduct) this.productList.get(productIndex);
            if (product.getCount() >= count) {
                if (clientIndex >= 0) {
                    Client client = (Client) this.clientList.get(clientIndex);
                    client.getBasket().addItem(product, count);
                    product.setCount(product.getCount() - count);
                } else {
                    System.out.println("Costumer id not valid");
                }
            } else {
                System.out.println("We don't have as many product packets as the customer requires");
            }

        } else {
            System.out.println("Barcode not valid");
        }
    }

    public void removeFromBasket(int barcodeId, int count, int customerId) {
        int clientIndex = compareClientId(customerId);
        if (clientIndex >= 0) {
            Client client = (Client) this.clientList.get(clientIndex);
            int productClientIndex = compareBarcodeId(barcodeId, client.getBasket().getListProducts());
            if (productClientIndex >= 0) {
                int productStoreIndex = compareBarcodeId(barcodeId, this.productList);
                if (productStoreIndex >= 0) {
                    GenericProduct product = (GenericProduct) client.getBasket().getListProducts().get(productClientIndex);
                    GenericProduct productGlobal = (GenericProduct) this.productList.get(productStoreIndex);
                    int productQuantity = product.getCount();
                    if (productQuantity > count) {
                        product.setCount(productQuantity - count);
                        productGlobal.setCount(productGlobal.getCount() + count);
                    } else if (productQuantity == count) {
                        client.getBasket().getListProducts().removeByIndex(productClientIndex);
                        productGlobal.setCount(productGlobal.getCount() + count);
                    } else {
                        System.out.println("You only have " + productQuantity + " packages of this products and you want to remove " + count + " please, enter a valid quantity");
                    }
                } else {
                    System.out.println("The barcode corresponds to a fresh product, this can't be remove from the basket");
                }
            } else {
                System.out.println("The product is not part of the client's basket");
            }
        }

    }

    public void printBasket(int customerId) {
        int clientIndex = compareClientId(customerId);
        Client client = (Client) this.clientList.get(clientIndex);
        System.out.println(client.getBasket().getListProducts().toString());
    }

    public float computeBasketPrice(int customerId) {
        int clientIndex = compareClientId(customerId);
        if (clientIndex >= 0) {
            Client client = (Client) this.clientList.get(clientIndex);
            float total = 0;
            for (int i = 0; i < client.getBasket().getListProducts().size(); i++) {
                if (client.getBasket().getListProducts().get(i) instanceof GenericProduct) {
                    GenericProduct product = (GenericProduct) client.getBasket().getListProducts().get(i);
                    total += product.getPrice() * product.getCount();
                } else if (client.getBasket().getListProducts().get(i) instanceof FreshProduct) {
                    FreshProduct product = (FreshProduct) client.getBasket().getListProducts().get(i);
                    total += product.getPrice() * product.getAmountInKg();
                }
            }
            return total;
        }
        return -1;
    }

    public void requestFreshProduct(int barcodeId, float amount, int customerId) {
        int clientIndex = compareClientId(customerId);
        if (clientIndex >= 0) {
            int productStoreIndex = compareBarcodeId(barcodeId, this.freshProductList);
            if (productStoreIndex >= 0) {
                FreshProductRequested request = new FreshProductRequested(customerId, barcodeId, amount);
                this.requestingFreshList.push(request);
            }
        }
    }

    public boolean serveNextRequest() {
        FreshProductRequested request = (FreshProductRequested) this.requestingFreshList.top();
        int barcode = request.getBarcodeId();
        int freshProductIndex = compareBarcodeId(barcode, this.freshProductList);
        FreshProduct product = (FreshProduct) this.freshProductList.get(freshProductIndex);
        if (product.getAmountInKg() >= request.getAmount()) {
            int clientIndex = compareClientId(request.getCustomerId());
            Client client = (Client) this.clientList.get(clientIndex);
            client.getBasket().addFreshProduct(product, request.getAmount());
            product.setAmountInKg(product.getAmountInKg() - request.getAmount());
            this.requestingFreshList.pop();
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

    /**
     * Get list of products in the store
     *
     * @return
     */
    public LinkedList getProductList() {
        return productList;
    }

    /**
     * Get list of fresh products in the store
     *
     * @return
     */
    public LinkedList getFreshProductList() {
        return freshProductList;
    }

    public Queue getRequestingFreshList() {
        return requestingFreshList;
    }
}
