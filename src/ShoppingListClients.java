/**
 * The shopping list of a client is a list of products that the client wants to buy.
 * It is not related with the products already in the basket. This list is stored in a dictionary
 *
 * @author Claudia Vaquera
 */
public class ShoppingListClients {
    private Dictionary shoppingList;

    public ShoppingListClients() {
        this.shoppingList = new Dictionary();
    }

    /**
     * Adds new products to the list
     *
     * @param newProduct Product
     */
    public void addNewItem(ProductToShoppingList newProduct) {
        this.shoppingList.add(newProduct.getBarcodeId(), newProduct);
    }

    /**
     * Gets shopping list
     *
     * @return list
     */
    public Dictionary getShoppingList() {
        return this.shoppingList;
    }

    /**
     * Removes first product in the list
     */
    public void removeItem() {
        this.shoppingList.remove();
    }

    /**
     * Gets size of the list
     *
     * @return size
     */
    public int getSize() {
        return this.shoppingList.size();
    }

    /**
     * traverse the list and creates a string representation of the list
     *
     * @return created string
     */
    public String toString() {
        String values = "";
        for (int i = 0; i < this.shoppingList.size(); i++) {
            ProductToShoppingList product = (ProductToShoppingList) this.shoppingList.get(i);
            values += "Name: " + product.getName() + ", qty: " + product.getAmount() + "\n";
        }
        return values;
    }
}
