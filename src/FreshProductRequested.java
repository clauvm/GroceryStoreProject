/**
 * This class if for the fresh product requested for the client, since it's not possible just add it to the basket
 *
 * @author Claudia Vaquera
 */
public class FreshProductRequested implements Comparable {
    private int customerId;
    private int barcodeId;
    private float amount;

    public FreshProductRequested(int customerId, int barcodeId, float amount) {
        this.customerId = customerId;
        this.barcodeId = barcodeId;
        this.amount = amount;
    }

    /**
     * Gets the customer id of the request
     *
     * @return customer id
     */
    public int getCustomerId() {
        return customerId;
    }

    /**
     * Gets the barcode of the fresh product requested
     *
     * @return barcode
     */
    public int getBarcodeId() {
        return barcodeId;
    }

    /**
     * Gets the amount of the fresh product requested
     *
     * @return amount
     */
    public float getAmount() {
        return amount;
    }

    /**
     * Compare de client id
     *
     * @return the result of the comparison
     */
    public int compareTo(Object client) {
        FreshProductRequested requestClient = (FreshProductRequested) client;
        return ((Comparable) customerId).compareTo(requestClient.customerId);
    }

    /**
     * Creates a string representation of the dictionary
     *
     * @return created string
     */
    public String toString() {
        String result = "Client : " + this.getCustomerId() + "\n";
        result += "Barcode Product : " + this.getBarcodeId() + "\n";
        result += "Amount in kg requested : " + String.valueOf(this.getAmount()) + "\n\n";
        return result;
    }

}
