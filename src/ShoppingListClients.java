public class ShoppingListClients {
    private Dictionary shoppingList;

    public ShoppingListClients() {
        this.shoppingList = new Dictionary();
    }

    public void addNewItem(Product newProduct) {
        this.shoppingList.add(newProduct.getBarcode(), newProduct);
    }

    public Dictionary getShoppingList() {
        return this.shoppingList;
    }

    public void removeItem() {
        this.shoppingList.remove();
    }

    public int getSize() {
        return this.shoppingList.size();
    }

    public String toString() {
        String values = "";
        for (int i = 0; i < this.shoppingList.size(); i++) {
            Product product = (Product) this.shoppingList.get(i);
            values += "Name: " + product.getName() + ", qty: " + product.getAmount() + "\n";
        }
        return values;
    }
}
