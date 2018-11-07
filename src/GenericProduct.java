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

}
