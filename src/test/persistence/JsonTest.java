package persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

import model.GroceryItem;

// Used JsonSerializationDemo as reference to structure this class
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class JsonTest {
    protected void checkGroceryItem(String name, int quantityInInventory, int quantityInShoppingList, String category,
            GroceryItem groceryItem) {
        assertEquals(name, groceryItem.getName());
        assertEquals(quantityInInventory, groceryItem.getQuantityInInventory());
        assertEquals(quantityInShoppingList, groceryItem.getQuantityInShoppingList());
        assertEquals(category, groceryItem.getCategory());
    }
}
