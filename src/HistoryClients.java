public class HistoryClients {
    private LinkedList history;

    public HistoryClients() {
        this.history = new LinkedList();
    }

    /**
     * Add products to the history
     *
     * @param item Product
     */
    public void addItem(Product item) {
        GenericProduct newProduct = new GenericProduct(item.getDepartment(), item.getName(), item.getPrice(), item.getBarcode(), (int) item.getAmount(), item.getIsFreshProduct());
        history.addFirst(newProduct);
    }

    public void addFreshProduct(Product product) {
        FreshProduct newProduct = new FreshProduct(product.getName(), product.getPrice(), product.getBarcode(), (float) product.getAmount(), product.getIsFreshProduct());
        history.addFirst(newProduct);
    }
}
