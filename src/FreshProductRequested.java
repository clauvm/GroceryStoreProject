public class FreshProductRequested implements Comparable {
    private int customerId;
    private int barcodeId;
    private float amount;

    public FreshProductRequested(int customerId, int barcodeId, float amount) {
        this.customerId = customerId;
        this.barcodeId = barcodeId;
        this.amount = amount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getBarcodeId() {
        return barcodeId;
    }

    public float getAmount() {
        return amount;
    }

    public int compareTo(Object client) {
        FreshProductRequested requestClient = (FreshProductRequested) client;
        return ((Comparable) customerId).compareTo(requestClient.customerId);
    }

    @Override
    public String toString() {
        String result = "Client : " + this.getCustomerId() + "\n";
        result += "Barcode Product : " + this.getBarcodeId() + "\n";
        result += "Amount in kg requested : " + String.valueOf(this.getAmount()) + "\n";
        return result;
    }

}
