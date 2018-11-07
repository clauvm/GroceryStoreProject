public class FreshProduct extends Product {
    private float amountInKg;

    public FreshProduct(String name, float price, int barcode, float amountInKg) {
        super(name, price, barcode);
        this.amountInKg = amountInKg;
    }

    public float getAmountInKg() {
        return amountInKg;
    }

    public void setAmountInKg(float amountInKg) {
        this.amountInKg = amountInKg;
    }
}
