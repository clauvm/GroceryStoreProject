/*Claudia Vaquera*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroceryStore implements GroceryStoreInterface {

    private LinkedList productList;
    private LinkedList freshProductList;
    private LinkedList clientList;
    private int idClient;

    public GroceryStore() {
        this.productList = new LinkedList();
        this.freshProductList = new LinkedList();
        this.clientList = new LinkedList();
        this.idClient = 0;
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
        System.out.println("Enter the number of the packages of the product");
        BufferedReader bufferedReaderQuantityPackages = new BufferedReader(new InputStreamReader(System.in));
        int quantityPackages = Integer.parseInt(bufferedReaderQuantityPackages.readLine());
        if (type == 0) {
            System.out.println(getProductList());
            System.out.println("Enter the barcode of the product you want to add");
            BufferedReader bufferedReaderProductBarcode = new BufferedReader(new InputStreamReader(System.in));
            int productBarcode = Integer.parseInt(bufferedReaderProductBarcode.readLine());
            addToBasket(productBarcode, quantityPackages, clientId);
        } else {
            System.out.println("Enter the barcode of the product you want to remove");
            BufferedReader bufferedReaderProductBarcode = new BufferedReader(new InputStreamReader(System.in));
            int productBarcode = Integer.parseInt(bufferedReaderProductBarcode.readLine());
            removeFromBasket(productBarcode, quantityPackages, clientId);
        }
    }

    public int compareClientId(int id) {
        Client temp = new Client("test", id);
        return clientList.contains(temp);
    }

    public int compareBarcodeId(int barcode, LinkedList list) {
        Product temp = new Product("test", 0, barcode);
        return list.contains(temp);
    }
    /**
     * Add products to grocery store
     *
     * @throws IOException
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
        int productIndex = compareBarcodeId(barcodeId, productList);
        if (productIndex >= 0) {
            GenericProduct product = (GenericProduct) this.productList.get(productIndex);
            if (product.getCount() >= count) {
                if (clientIndex >= 0) {
                    Client client = (Client) this.clientList.get(clientIndex);
                    client.getBasket().addItem(product, count);
//                    GenericProduct clientsList = client.getBasket().getListProducts();
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
            LinkedList clientsProducts = client.getBasket().getListProducts();
            int productIndex = compareBarcodeId(barcodeId, clientsProducts);
            System.out.println("Is product in clients basket? " + productIndex);
        }

    }

    public void printBasket(int customerId) {

    }

    public float computeBasketPrice(int customerId) {
        return 0;
    }

    public void requestFreshProduct(int barcodeId, float amount, int customerId) {

    }

    public boolean serveNextRequest() {
        return true;
    }

    public void printUnservedRequests() {

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

    public LinkedList getClientList() {
        return clientList;
    }

    public int getIdClient() {
        return idClient;
    }
}
