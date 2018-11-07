/* Claudia Vaquera*/
public class Client {

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

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}
