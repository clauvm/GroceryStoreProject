/* Claudia Vaquera*/
public class Client implements Comparable {

    private String name;
    private Basket basket;
    private int id;
    private HistoryClients history;
    private ShoppingListClients shoppingList;

    public Client(String name, int id) {
        this.name = name;
        this.basket = new Basket();
        this.id = id;
        this.history = new HistoryClients();
        this.shoppingList = new ShoppingListClients();
    }

    /**
     * get client's basket
     *
     * @return
     */
    public Basket getBasket() {
        return this.basket;
    }

    public HistoryClients getHistory() {
        return this.history;
    }

    public ShoppingListClients getShoppingList() {
        return this.shoppingList;
    }

    public void deleteBasket() {
        while (this.basket.getListProducts().size() > 0) {
            this.basket.removeFirstItem();
        }
    }

    public void clearShoppingList() {
        while (this.shoppingList.getShoppingList().size() > 0) {
            this.shoppingList.removeItem();
        }
    }

    public int compareTo(Object clientToCompare) {
        Client currentClient = (Client) clientToCompare;
        return ((Comparable) id).compareTo(currentClient.id);
    }
}
