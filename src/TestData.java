/**
 * This class creates some data to avoid doing it manually, it's not important
 * but it helps to test all the functionalities
 */
public class TestData {
    public TestData(GroceryStore groceryStore) {
        createHardcodedData(groceryStore);
    }

    /**
     * Creates data in the grocery store already created
     *
     * @param groceryStore GroceryStore
     */
    public void createHardcodedData(GroceryStore groceryStore) {
        groceryStore.addDepartment("Entry");
        groceryStore.addDepartment("Fresh Products"); //Department where the client request a fresh product
        groceryStore.addDepartment("Exit");
        groceryStore.addDepartment("Fruits");
        groceryStore.addDepartment("Candies");
        groceryStore.addDepartment("Teas");
        groceryStore.addDepartment("Bakery");
        groceryStore.addDepartment("Pastry");
        groceryStore.addDepartment("Snacks");

        groceryStore.addClient("Claudia");
        groceryStore.addClient("Hugo");
        groceryStore.addClient("Katty");

        groceryStore.addProduct("Fruits", "Oranges", 1.48f, 234, 12);
        groceryStore.addProduct("Fruits", "Apples", 1.05f, 456, 20);
        groceryStore.addProduct("Bakery", "Bread", 1.05f, 890, 11);
        groceryStore.addProduct("Teas", "Morocco Tea", 1.69f, 113, 21);
        groceryStore.addProduct("Candies", "M&M's", 1.5f, 116, 12);
        groceryStore.addProduct("Bakery", "Cheesecake", 4.89f, 119, 13);
        groceryStore.addProduct("Teas", "Blueberry Tea", 5.75f, 221, 11);
        groceryStore.addProduct("Candies", "Skittles", 1.25f, 223, 31);
        groceryStore.addProduct("Snacks", "Lay's Paprika", 1.36f, 225, 10);
        groceryStore.addProduct("Pastry", "Flour", 1.36f, 226, 10);

        groceryStore.addFreshProduct("Chicken", 15.45f, 987, 9.5f);
        groceryStore.addFreshProduct("Chicken wings", 17.5f, 876, 8.55f);
        groceryStore.addFreshProduct("Beef steak", 14.3f, 765, 10.85f);
        groceryStore.addFreshProduct("Filet", 14.75f, 654, 15.95f);

        groceryStore.connectDepartments("Entry", "Exit");
        groceryStore.connectDepartments("Entry", "Pastry");
        groceryStore.connectDepartments("Pastry", "Bakery");
        groceryStore.connectDepartments("Pastry", "Teas");
        groceryStore.connectDepartments("Bakery", "Snacks");
        groceryStore.connectDepartments("Snacks", "Fruits");
        groceryStore.connectDepartments("Candies", "Fresh Products");
        groceryStore.connectDepartments("Fresh Products", "Teas");
        groceryStore.connectDepartments("Teas", "Snacks");
        groceryStore.connectDepartments("Teas", "Exit");
        groceryStore.connectDepartments("Candies", "Exit");

        groceryStore.addToBasket(234, 1, 1);
        groceryStore.addToBasket(456, 2, 1);
        groceryStore.addToBasket(113, 4, 1);
        groceryStore.addToBasket(119, 3, 2);
        groceryStore.addToBasket(890, 4, 2);
        groceryStore.addToBasket(221, 2, 1);
        groceryStore.addToBasket(226, 3, 2);

        groceryStore.requestFreshProduct(987, 1.5f, 2);
        groceryStore.requestFreshProduct(876, 0.75f, 1);
        groceryStore.requestFreshProduct(765, 1.55f, 2);

        groceryStore.addToBasket(113, 2, 1);
        groceryStore.addToBasket(223, 5, 2);
        groceryStore.addToBasket(225, 2, 1);

        groceryStore.addToShoppingList(225, 1, 1);
        groceryStore.addToShoppingList(987, 1, 1);
        groceryStore.addToShoppingList(226, 1, 1);
    }
}
