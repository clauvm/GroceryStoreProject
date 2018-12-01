/*Claudia Vaquera*/
public abstract class Product implements Comparable {
    //public class Product implements Comparable {
    private String name;
    private float price;
    private int barcode;
    private boolean isFreshProduct;

    /**
     * Constructor
     *
     * @param name
     * @param price
     * @param barcode
     */
    public Product(String name, float price, int barcode, boolean isFresh) {
        this.name = name;
        this.price = price;
        this.barcode = barcode;
        this.isFreshProduct = isFresh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public boolean getIsFreshProduct() {
        return isFreshProduct;
    }

    public void setIsFreshProduct(boolean isFresh) {
        this.isFreshProduct = isFresh;
    }

    public int compareTo(Object productToCompare) {
        Product product = (Product) productToCompare;
        return ((Comparable) barcode).compareTo(product.barcode);
    }

    public abstract double getAmount();

    public abstract String getDepartment();

    public abstract void setAmount(double amount);

}
