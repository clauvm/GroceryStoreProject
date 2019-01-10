/**
 * This class extends the product class, the amount in kg is a float
 *
 * @author Claudia Vaquera
 */
public class FreshProduct extends Product {
    private float amountInKg;

    /* name, price and barcode are extended from product */
    public FreshProduct(String name, float price, int barcode, float amountInKg, boolean isFresh) {
        super(name, price, barcode, isFresh);
        this.amountInKg = amountInKg;
    }

    /**
     * Gets the amount in kg of th fresh product
     */
    private float getAmountInKg() {
        return this.amountInKg;
    }

    /**
     * Gets the amount in kg of the fresh product, it's an abstract method
     *
     * @return amount
     */
    public double getAmount() {
        return amountInKg;
    }

    /**
     * Abstract method from product
     *
     * @return null because a fresh product doesn't have a department
     */
    public String getDepartment() {
        return null;
    }

    /**
     * Set current amount of the fresh product, since the value is type float, it needs to be casted,
     * abstract method
     *
     * @param amount double
     */
    public void setAmount(double amount) {
        this.amountInKg = (float) amount;
    }

    /**
     * Creates a string representation of the fresh product
     *
     * @return created string
     */
    public String toString() {
        String result = "Product Name : " + super.getName() + "\n";
        result += "Product Price : " + String.valueOf(super.getPrice()) + "€" + "\n";
        result += "Product Barcode : " + super.getBarcode() + "\n";
        result += "Product Amount : " + this.getAmountInKg() + "\n";
        result += "Fresh Product : " + this.getIsFreshProduct() + "\n\n";
        return result;
    }
}
