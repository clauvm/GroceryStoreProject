/*Claudia Vaquera*/
public class Basket {

    private LinkedList listProducts;

    public Basket() {
        this.listProducts = new LinkedList();
    }

    /**
     * Add products to the basket
     *
     * @param item
     */
    public void addItem(GenericProduct item, int count) {
        GenericProduct newProduct = new GenericProduct(item.getName(), item.getPrice(), item.getBarcode(), count);
        listProducts.addLast(newProduct);
    }

    public void addFreshProduct(FreshProduct product, float amount) {
        FreshProduct newProduct = new FreshProduct(product.getName(), product.getPrice(), product.getBarcode(), amount);
        listProducts.addLast(newProduct);
    }

    /**
     * Remove products to the basket using index
     *
     * @param index
     */
    public void removeItem(int index) {
        listProducts.removeByIndex(index);
    }

    /**
     * Get list of products
     *
     * @return
     */
    public LinkedList getListProducts() {
        return listProducts;
    }


}
