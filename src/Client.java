/* Claudia Vaquera*/
public class Client implements Comparable {

    private String name;
    private Basket basket;
    private int id;
    private HistoryClients history;

    public Client(String name, int id) {
        this.name = name;
        this.basket = new Basket();
        this.id = id;
        this.history = new HistoryClients();
    }

    /**
     * get client's basket
     *
     * @return
     */
    public Basket getBasket() {
        return basket;
    }

    public HistoryClients getHistory() {
        return history;
    }

    public void deleteBasket() {
        while (basket.getListProducts().size() > 0) {
            Product product = (Product) basket.getListProducts().get(0);
            basket.removeItem(product.getBarcode());
        }
    }

    public int compareTo(Object clientToCompare) {
        Client currentClient = (Client) clientToCompare;
        return ((Comparable) id).compareTo(currentClient.id);
    }
}
