/* Claudia Vaquera*/
public class Client {

    private String name;
    private Basket basket;

    public Client(String name) {
        this.name = name;
        this.basket = new Basket();
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
