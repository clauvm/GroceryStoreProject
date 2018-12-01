public class FreshProduct extends Product {
    private float amountInKg;

    public FreshProduct(String name, float price, int barcode, float amountInKg, boolean isFresh) {
        super(name, price, barcode, isFresh);
        this.amountInKg = amountInKg;
    }

    public float getAmountInKg() {
        return amountInKg;
    }

    public void setAmountInKg(float amountInKg) {
        this.amountInKg = amountInKg;
    }

    @Override
    public String toString() {
        String result = "Product Name : " + super.getName() + "\n";
        result += "Product Price : " + String.valueOf(super.getPrice()) + "€" + "\n";
        result += "Product Barcode : " + super.getBarcode() + "\n";
        result += "Product Amount : " + this.getAmountInKg() + "\n";
        result += "Fresh Product : " + this.getIsFreshProduct() + "\n\n";
        return result;
    }

    public double getAmount() {
        return amountInKg;
    }

    public String getDepartment() {
        return null;
    }

    public void setAmount(double amount) {
        this.amountInKg = (float) amount;
    }
}
