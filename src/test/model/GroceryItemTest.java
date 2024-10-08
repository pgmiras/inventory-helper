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

    @Test
    public void testIncreaseQuantityInInventory(int amount){
        testGroceryItem.increaseQuantityInInventory(3);
        assertEquals(3, testGroceryItem.getQuantityInInventory());
    }

    @Test  
    public void testDecreaseQuantityInInventoryList(int amount){
        testGroceryItem.increaseQuantityInInventory(5);
        assertEquals(5, testGroceryItem.getQuantityInInventory());
        testGroceryItem.decreaseQuantityInInventory(3);
        assertEquals(2, testGroceryItem.getQuantityInInventory());
    }

    @Test
    public void testIncreaseQuantityInShoppingList(int amount){
        testGroceryItem.increaseQuantityInShoppingList(5);
        assertEquals(5, testGroceryItem.getQuantityInShoppingList());
    }

    @Test  
    public void testDecreaseQuantityInShoppingList(int amount){
        testGroceryItem.increaseQuantityInShoppingList(6);
        assertEquals(6, testGroceryItem.getQuantityInShoppingList());
        testGroceryItem.decreaseQuantityInShoppingList(4);
        assertEquals(2, testGroceryItem.getQuantityInShoppingList());
    }
}
