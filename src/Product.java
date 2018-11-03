/*Claudia Vaquera*/
public class Product {
    private String name;
    private double price;
    private int barcode;

    /**
     * Constructor
     *
     * @param name
     * @param price
     * @param barcode
     */
    public Product(String name, double price, int barcode) {
        this.name = name;
        this.price = price;
        this.barcode = barcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    @Override
    public String toString() {
        String result = "Product Name : " + this.getName() + "\n";
        result += "Product Price : " + String.valueOf(this.getPrice()) + "\n";
        result += "Product Barcode : " + this.getBarcode() + "\n\n";
        return result;

    }

}
