import java.math.BigDecimal;

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

    public String toString() {
        String values = "";
        String count;
        for (int i = 0; i < history.size(); i++) {
            Product product = (Product) history.get(i);
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
