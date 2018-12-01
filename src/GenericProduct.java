public class GenericProduct extends Product {

    private int count;
    private String department;

    public GenericProduct(String department, String name, float price, int barcode, int count, boolean isFresh) {
        super(name, price, barcode, isFresh);
        this.count = count;
        this.department = department;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        String result = "Product Department: " + this.getDepartment() + "\n";
        result += "Product Name: " + super.getName() + "\n";
        result += "Product Price: " + String.valueOf(super.getPrice()) + "\n";
        result += "Product Barcode: " + super.getBarcode() + "\n";
        result += "Product Count: " + this.getCount() + "\n";
        result += "Fresh Product: " + this.getIsFreshProduct() + "\n\n";
        return result;
    }

    public double getAmount() {
        return count;
    }

    public void setAmount(double amount) {
        this.count = (int) amount;
    }

}
