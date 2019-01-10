/**
 * Product class, it has a name, price and barcode. It's possible to know if it's a fresh product or not
 * It also has abstract methods to get and set the amount, and to get the department
 *
 * @author Claudia Vaquera
 */
public abstract class Product implements Comparable {
    private String name;
    private float price;
    private int barcode;
    private boolean isFreshProduct;

    public Product(String name, float price, int barcode, boolean isFresh) {
        this.name = name;
        this.price = price;
        this.barcode = barcode;
        this.isFreshProduct = isFresh;
    }

    /**
     * Gets name of the product
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets price of the product
     *
     * @return price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Gets barcode of the product
     *
     * @return barcode
     */
    public int getBarcode() {
        return barcode;
    }

    /**
     * Shows if the product is a fresh product or not
     *
     * @return is fresh
     */
    public boolean getIsFreshProduct() {
        return isFreshProduct;
    }


    /**
     * Compares the barcode of a product
     *
     * @param productToCompare Object
     * @return result of the comparison
     */
    public int compareTo(Object productToCompare) {
        Product product = (Product) productToCompare;
        return ((Comparable) barcode).compareTo(product.barcode);
    }

    /**
     * Abstract method to get the amount, implemented in GenericProducts and FreshProducts
     *
     * @return amount
     */
    public abstract double getAmount();

    /**
     * Abstract method to get the department, implemented in GenericProducts and FreshProducts
     * @return department
     */
    public abstract String getDepartment();

    /**
     * Abstract method to set the amount, implemented in GenericProducts and FreshProducts
     * @param amount double
     */
    public abstract void setAmount(double amount);

}
