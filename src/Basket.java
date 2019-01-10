/**
 * Basket class, it contains a list of products,
 * in a dictionary, and the methods to handle it
 *
 * @author Claudia Vaquera
 */
public class Basket {

    private Dictionary listProducts;

    public Basket() {
        this.listProducts = new Dictionary();
    }

    /**
     * Add products to the basket
     *
     * @param newProduct Product
     */
    public void addProduct(Product newProduct) {
        this.listProducts.add(newProduct.getBarcode(), newProduct);
    }

    /**
     * Remove products to the basket using index
     *
     * @param barcodeId int
     */
    public void removeItem(int barcodeId) {
        this.listProducts.removeByIndex(barcodeId);
    }

    /**
     * Remove first product in the basket
     */
    public void removeFirstItem() {
        this.listProducts.remove();
    }

    /**
     * Get list of products
     *
     * @return list of products
     */
    public Dictionary getListProducts() {
        return this.listProducts;
    }


}
