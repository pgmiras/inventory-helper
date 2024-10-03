package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GroceryItemTest {
    private GroceryItem testGroceryItem;

    @BeforeEach
    void runBefore() {
        testGroceryItem = new GroceryItem("milk", "dairy");
    }

    @Test
    void testConstructor() {
        assertEquals("milk", testGroceryItem.getName());
        assertEquals(0, testGroceryItem.getQuantityInInventory());
        assertEquals(0, testGroceryItem.getQuantityInShoppingList());
        assertEquals("dairy", testGroceryItem.getCategory());
    }
}
