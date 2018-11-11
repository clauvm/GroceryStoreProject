public class GenericProduct extends Product {

    private int count;

    public GenericProduct(String name, float price, int barcode, int count) {
        super(name, price, barcode);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        String result = "Product Name : " + super.getName() + "\n";
        result += "Product Price : " + String.valueOf(super.getPrice()) + "\n";
        result += "Product Barcode : " + super.getBarcode() + "\n";
        result += "Product Count : " + this.getCount() + "\n\n";
        return result;
    }

}
