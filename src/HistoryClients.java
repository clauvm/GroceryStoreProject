import java.math.BigDecimal;

public class HistoryClients {
    private LinkedList history;

    public HistoryClients() {
        this.history = new LinkedList();
    }

    /**
     * Add products to the history
     *
     * @param product Product
     */

    public void addNewItem(Product product) {
        this.history.addFirst(product);
    }

    public String toString() {
        String values = "";
        String count;
        for (int i = 0; i < this.history.size(); i++) {
            Product product = (Product) this.history.get(i);
            if (product.getIsFreshProduct()) {
                float amount = round((float) product.getAmount(), 2);
                count = String.valueOf(amount);
            } else {
                int amount = (int) product.getAmount();
                count = String.valueOf(amount);
            }
            values += count + " " + product.getName() + " --> " + round(((float) (product.getPrice() * product.getAmount())), 2) + " €" + "\n";
        }
        return values;
    }

    public static float round(float number, int decimalPlace) {
        BigDecimal bd = new BigDecimal(number);
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }
}
