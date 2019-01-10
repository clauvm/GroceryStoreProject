/**
 * Client class, a client is registered in the grocery store,
 * each clint has an id, name, basket, history and a shopping list
 *
 * @author Claudia Vaquera
 */
public class Client implements Comparable {

    private int id;
    private String name;
    private Basket basket;
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
     * Gets client's basket with the added products
     *
     * @return basket
     */
    public Basket getBasket() {
        return this.basket;
    }

    /**
     * Gets client's history of purchase
     *
     * @return history
     */
    public HistoryClients getHistory() {
        return this.history;
    }

    /**
     * Gets client's shopping list, this list is not related to the basket
     *
     * @return shopping list
     */
    public ShoppingListClients getShoppingList() {
        return this.shoppingList;
    }

    /**
     * Deletes each product in the basket after the client checks out
     */
    public void deleteBasket() {
        while (this.basket.getListProducts().size() > 0) {
            this.basket.removeFirstItem();
        }
    }

    /**
     * Deletes each product in the shopping list
     */
    public void clearShoppingList() {
        while (this.shoppingList.getShoppingList().size() > 0) {
            this.shoppingList.removeItem();
        }
    }

    /**
     * Compare de client id
     *
     * @return the result of the comparison
     */
    public int compareTo(Object clientToCompare) {
        Client currentClient = (Client) clientToCompare;
        return ((Comparable) id).compareTo(currentClient.id);
    }
}
