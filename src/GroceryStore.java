/*Claudia Vaquera*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GroceryStore {

    private LinkedList productList;
    private Client client;

    public GroceryStore() {
        this.productList = new LinkedList();
        this.client = new Client("Clau");
    }

    /**
     * Add products to grocery store
     *
     * @throws IOException
     */
    public void addProduct() throws IOException {
        System.out.println("Product name?");
        BufferedReader bufferedReaderName = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReaderName.readLine();

        System.out.println("Product price?");
        BufferedReader bufferedReaderPrice = new BufferedReader(new InputStreamReader(System.in));
        double price = Double.parseDouble(bufferedReaderPrice.readLine());

        System.out.println("Product barcode?");
        BufferedReader bufferedReaderBarcode = new BufferedReader(new InputStreamReader(System.in));
        int barcode = Integer.parseInt(bufferedReaderBarcode.readLine());


        Product newProduct = new Product(name, price, barcode);
        this.productList.addLast(newProduct);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    /**
     * Get list of products in the store
     *
     * @return
     */
    public LinkedList getProductList() {
        return productList;
    }
}
