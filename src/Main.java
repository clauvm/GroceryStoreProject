/**
 * Main class of the project, it calls to the TestData and UserOptions classes
 *
 * @author Claudia Vaquera
 */

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GroceryStore groceryStore = new GroceryStore();
        new TestData(groceryStore);     //Creates default data
        new UserOptions(groceryStore);
    }
}
