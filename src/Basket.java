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
        String name = item.getName();
        float price = item.getPrice();
        int barcode = item.getBarcode();
        GenericProduct test = new GenericProduct(name, price, barcode, count);
        listProducts.addLast(test);
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
