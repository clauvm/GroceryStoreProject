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
    public void addItem(Product item) {
        listProducts.addLast(item);
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
