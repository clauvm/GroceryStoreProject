import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GroceryStore groceryStore = new GroceryStore();
        TestData test = new TestData(groceryStore);
        UserOptions options = new UserOptions(groceryStore);
    }
}
