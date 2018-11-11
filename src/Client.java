/* Claudia Vaquera*/
public class Client implements Comparable {

    private String name;
    private Basket basket;
    private int id;

    public Client(String name, int id) {
        this.name = name;
        this.basket = new Basket();
        this.id = id;
    }

    /**
     * get client's basket
     *
     * @return
     */
    public Basket getBasket() {
        return basket;
    }

    public int compareTo(Object clientToCompare) {
        Client currentClient = (Client) clientToCompare;
        return ((Comparable) id).compareTo(currentClient.id);
    }
}
