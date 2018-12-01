/*Claudia Vaquera*/
public class Basket {

    private Dictionary listProducts;

    public Basket() {
        this.listProducts = new Dictionary();
    }

    /**
     * Add products to the basket
     *
     * @param item
     */
    public void addItem(Product item, int count) {
        GenericProduct newProduct = new GenericProduct(item.getDepartment(), item.getName(), item.getPrice(), item.getBarcode(), count, item.getIsFreshProduct());
        listProducts.add(item.getBarcode(), newProduct);
    }

    public void addFreshProduct(Product product, float amount) {
        FreshProduct newProduct = new FreshProduct(product.getName(), product.getPrice(), product.getBarcode(), amount, product.getIsFreshProduct());
        listProducts.add(product.getBarcode(), newProduct);
    }

    /**
     * Remove products to the basket using index
     *
     * @param barcodeId
     */
    public void removeItem(int barcodeId) {
        listProducts.remove(barcodeId);
    }

    /**
     * Get list of products
     *
     * @return
     */
    public Dictionary getListProducts() {
        return listProducts;
    }


}
