/**
 * This class also manages the product in a client's shopping list
 *
 * @author Claudia Vaquera
 */
public class ProductToShoppingList implements Comparable {
    private int customerId;
    private int barcodeId;
    private String name;
    private int amount;
    private String department;

    public ProductToShoppingList(int customerId, int barcodeId, String name, int amount, String department) {
        this.customerId = customerId;
        this.barcodeId = barcodeId;
        this.name = name;
        this.amount = amount;
        this.department = department;
    }

    /**
     * Gets the customer id
     *
     * @return customer id
     */
    public int getCustomerId() {
        return this.customerId;
    }

    /**
     * Gets the barcode of the product
     *
     * @return barcode
     */
    public int getBarcodeId() {
        return this.barcodeId;
    }

    /**
     * Gets the product name
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the amount of the product requested
     *
     * @return amount
     */
    public int getAmount() {
        return this.amount;
    }

    /**
     * Gets the product's department
     *
     * @return department
     */
    public String getDepartment() {
        return this.department;
    }

    /**
     * Compare de client id
     *
     * @return the result of the comparison
     */
    public int compareTo(Object client) {
        ProductToShoppingList requestClient = (ProductToShoppingList) client;
        return ((Comparable) customerId).compareTo(requestClient.customerId);
    }

    /**
     * Creates a string representation of the dictionary
     *
     * @return created string
     */
    public String toString() {
        String result = "Client: " + this.getCustomerId() + "\n";
        result += "Product Barcode: " + this.getBarcodeId() + "\n";
        result += "Product Amount : " + String.valueOf(this.getAmount()) + "\n\n";
        return result;
    }

}

