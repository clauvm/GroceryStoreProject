/*Claudia Vaquera*/
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
     * @param barcodeId
     */
    public void removeItem(int barcodeId) {
        this.listProducts.removebyIndex(barcodeId);
    }

    public void removeFirstItem() {
        this.listProducts.remove();
    }

    /**
     * Get list of products
     *
     * @return
     */
    public Dictionary getListProducts() {
        return this.listProducts;
    }


}
