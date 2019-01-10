import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GroceryStore groceryStore = new GroceryStore();
        new TestData(groceryStore);
        new UserOptions(groceryStore);
    }
}
