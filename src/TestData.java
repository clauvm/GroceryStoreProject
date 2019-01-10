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
        groceryStore.addDepartment("Dairy Products");
        groceryStore.addDepartment("Fruits");
        groceryStore.addDepartment("Cookies");
        groceryStore.addDepartment("Vegetables");
        groceryStore.addDepartment("Candies");
        groceryStore.addDepartment("Cheese");
        groceryStore.addDepartment("Teas");
        groceryStore.addDepartment("Coffee");
        groceryStore.addDepartment("Spices");
        groceryStore.addDepartment("Bakery");
        groceryStore.addDepartment("Pastry");
        groceryStore.addDepartment("Pastas");
        groceryStore.addDepartment("Cereal");
        groceryStore.addDepartment("Snacks");

        groceryStore.addClient("Claudia");
        groceryStore.addClient("Hugo");
        groceryStore.addClient("Katty");

        groceryStore.addProduct("Dairy Products", "Milk", 0.79f, 123, 10);
        groceryStore.addProduct("Fruits", "Oranges", 1.48f, 234, 12);
        groceryStore.addProduct("Cookies", "Qkies chocolate", 2.5f, 345, 15);
        groceryStore.addProduct("Fruits", "Apples", 1.05f, 456, 20);
        groceryStore.addProduct("Dairy Products", "Cecemel", 1.69f, 567, 27);
        groceryStore.addProduct("Vegetables", "Brussels Sprouts", 0.76f, 678, 27);
        groceryStore.addProduct("Dairy Products", "Vrije Melk", 0.89f, 789, 10);
        groceryStore.addProduct("Bakery", "Bread", 1.05f, 890, 11);
        groceryStore.addProduct("Spices", "Cinnamon", 2.3f, 21, 15);
        groceryStore.addProduct("Pastas", "Spaghetti", 1.15f, 112, 34);
        groceryStore.addProduct("Teas", "Morocco Tea", 1.69f, 113, 21);
        groceryStore.addProduct("Coffee", "Gold Nescafe", 4.57f, 114, 14);
        groceryStore.addProduct("Cereal", "Corn Flakes", 3.59f, 115, 17);
        groceryStore.addProduct("Candies", "M&M's", 1.5f, 116, 12);
        groceryStore.addProduct("Cereal", "Chocapic", 4.05f, 117, 6);
        groceryStore.addProduct("Cheese", "Cheddar Cheese", 3.85f, 118, 22);
        groceryStore.addProduct("Bakery", "Cheesecake", 4.89f, 119, 13);
        groceryStore.addProduct("Teas", "Blueberry Tea", 5.75f, 221, 11);
        groceryStore.addProduct("Cookies", "Chip's ahoy", 2.5f, 222, 9);
        groceryStore.addProduct("Candies", "Skittles", 1.25f, 223, 31);
        groceryStore.addProduct("Spices", "Paprika", 2.5f, 224, 25);
        groceryStore.addProduct("Snacks", "Lay's Paprika", 1.36f, 225, 10);

        groceryStore.addFreshProduct("Chicken", 15.45f, 987, 9.5f);
        groceryStore.addFreshProduct("Chicken wings", 17.5f, 876, 8.55f);
        groceryStore.addFreshProduct("Beef steak", 14.3f, 765, 10.85f);
        groceryStore.addFreshProduct("Filet", 14.75f, 654, 15.95f);

        groceryStore.connectDepartments("Entry", "Pastas");
        groceryStore.connectDepartments("Entry", "Spices");
        groceryStore.connectDepartments("Pastas", "Cereal");
        groceryStore.connectDepartments("Spices", "Bakery");
        groceryStore.connectDepartments("Spices", "Pastry");
        groceryStore.connectDepartments("Cereal", "Coffee");
        groceryStore.connectDepartments("Bakery", "Teas");
        groceryStore.connectDepartments("Bakery", "Fruits");
        groceryStore.connectDepartments("Pastry", "Fruits");
        groceryStore.connectDepartments("Pastry", "Vegetables");
        groceryStore.connectDepartments("Coffee", "Cookies");
        groceryStore.connectDepartments("Teas", "Coffee");
        groceryStore.connectDepartments("Fruits", "Dairy Products");
        groceryStore.connectDepartments("Cookies", "Snacks");
        groceryStore.connectDepartments("Cookies", "Candies");
        groceryStore.connectDepartments("Dairy Products", "Cheese");
        groceryStore.connectDepartments("Dairy Products", "Fresh Products");
        groceryStore.connectDepartments("Dairy Products", "Exit");
        groceryStore.connectDepartments("Snacks", "Exit");
        groceryStore.connectDepartments("Candies", "Exit");

        groceryStore.connectDepartments("Bakery", "Cookies");
        groceryStore.connectDepartments("Fruits", "Candies");
        groceryStore.connectDepartments("Vegetables", "Cookies");

        groceryStore.addToBasket(123, 1, 1);
        groceryStore.addToBasket(567, 2, 1);
        groceryStore.addToBasket(113, 4, 1);
        groceryStore.addToBasket(456, 3, 2);
        groceryStore.addToBasket(789, 4, 2);
        groceryStore.addToBasket(221, 2, 1);
        groceryStore.addToBasket(117, 3, 2);

        groceryStore.requestFreshProduct(987, 1.5f, 2);
        groceryStore.requestFreshProduct(876, 0.75f, 1);
        groceryStore.requestFreshProduct(765, 1.55f, 2);

        groceryStore.addToBasket(115, 2, 1);
        groceryStore.addToBasket(222, 5, 2);
        groceryStore.addToBasket(117, 2, 1);

        groceryStore.addToShoppingList(119, 1, 1);
        groceryStore.addToShoppingList(221, 1, 1);
        groceryStore.addToShoppingList(116, 1, 1);
        groceryStore.addToShoppingList(890, 1, 1);
        groceryStore.addToShoppingList(223, 1, 1);
        groceryStore.addToShoppingList(113, 1, 1);
    }
}
