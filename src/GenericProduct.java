/**
 * This class extends the product class, the quantity is an integer and it also has a department assigned
 *
 * @author Claudia Vaquera
 */
public class GenericProduct extends Product {

    private int count;
    private String department;

    /* name, price and barcode are extended from product */
    public GenericProduct(String department, String name, float price, int barcode, int count, boolean isFresh) {
        super(name, price, barcode, isFresh);
        this.count = count;
        this.department = department;
    }

    /**
     * Gets the quantity of the product
     *
     * @return count
     */
    private int getCount() {
        return this.count;
    }

    /**
     * Gets the quantity of the product, it's an abstract method
     *
     * @return count
     */
    public double getAmount() {
        return count;
    }

    /**
     * Set current amount of the product, since the value is an integer, it needs to be casted,
     * abstract method from product
     *
     * @param amount double
     */
    public void setAmount(double amount) {
        this.count = (int) amount;
    }

    /**
     * Gets department of the product
     *
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * Creates a string representation of the generic product
     *
     * @return created string
     */
    public String toString() {
        String result = "Product Department: " + this.getDepartment() + "\n";
        result += "Product Name: " + super.getName() + "\n";
        result += "Product Price: " + String.valueOf(super.getPrice()) + "€" + "\n";
        result += "Product Barcode: " + super.getBarcode() + "\n";
        result += "Product Count: " + this.getCount() + "\n";
        result += "Fresh Product: " + this.getIsFreshProduct() + "\n\n";
        return result;
    }
}
