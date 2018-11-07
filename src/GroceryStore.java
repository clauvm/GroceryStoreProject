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

        if (type == 1) {
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
        addClient(name);
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

    /**
     * Get list of products in the store
     *
     * @return
     */
    public LinkedList getProductList() {
        return productList;
    }

    /**
     * Get list of products in the store
     *
     * @return
     */
    public LinkedList getFreshProductList() {
        return freshProductList;
    }

    /**
     * Get list of products in the store
     *
     * @return
     */
    public LinkedList getClientList() {
        return clientList;
    }

    /**
     * Get list of products in the store
     *
     * @return
     */
    public int getIdClient() {
        return idClient;
    }
}
