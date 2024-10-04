package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShoppingListTest {
    private ShoppingList testShoppingList;
    private GroceryItem testGroceryItem1;
    private GroceryItem testGroceryItem2;

    @BeforeEach
    void runBefore() {
        testShoppingList = new ShoppingList();
        testGroceryItem1 = new GroceryItem("milk", "dairy");
        testGroceryItem2 = new GroceryItem("lettuce", "vegetables");
    }

    @Test
    void testConstructor() {
        HashSet<GroceryItem> testShoppingListList = testShoppingList.getShoppingList();
        assertEquals(0, testShoppingListList.size());
    }

    @Test
    void testAddOneItem() {
        HashSet<GroceryItem> testShoppingListList = testShoppingList.getShoppingList();
        testShoppingList.addItem(testGroceryItem1);
        assertEquals(1, testShoppingListList.size());
    }

    @Test
    void testAddMultipleDifferentItems() {
        HashSet<GroceryItem> testShoppingListList = testShoppingList.getShoppingList();
        testShoppingList.addItem(testGroceryItem1);
        assertEquals(1, testShoppingListList.size());
        testShoppingList.addItem(testGroceryItem2);
        assertEquals(2, testShoppingListList.size());
    }    

    @Test
    void testAddSameItemMultipleTimes() {
        HashSet<GroceryItem> testShoppingListList = testShoppingList.getShoppingList();
        testShoppingList.addItem(testGroceryItem1);
        assertEquals(1, testShoppingListList.size());
        testShoppingList.addItem(testGroceryItem1);
        assertEquals(1, testShoppingListList.size());
    }    

    @Test
    void testRemoveOneItem() {
        HashSet<GroceryItem> testShoppingListList = testShoppingList.getShoppingList();
        testShoppingList.addItem(testGroceryItem1);
        assertEquals(1, testShoppingListList.size());
        testShoppingList.removeItem(testGroceryItem1);
        assertEquals(0, testShoppingListList.size());
    }

    @Test
    void testRemoveMultipleDifferentItems() {
        HashSet<GroceryItem> testShoppingListList = testShoppingList.getShoppingList();
        testShoppingList.addItem(testGroceryItem1);
        testShoppingList.addItem(testGroceryItem2);
        assertEquals(2, testShoppingListList.size());
        testShoppingList.removeItem(testGroceryItem1);
        assertEquals(1, testShoppingListList.size());
        testShoppingList.removeItem(testGroceryItem2);
        assertEquals(0, testShoppingListList.size());
    }

    @Test
    void testIncreaseItemQuantity() {
        testShoppingList.increaseItemQuantity(testGroceryItem1, 2);
        assertEquals(2, testGroceryItem1.getQuantityInShoppingList());
    }

    @Test
    void testDecreaseItemQuantity() {
        testShoppingList.increaseItemQuantity(testGroceryItem1, 3);
        testShoppingList.decreaseItemQuantity(testGroceryItem1, 2);
        assertEquals(1, testGroceryItem1.getQuantityInShoppingList());
    }

    @Test
    void testDecreaseItemQuantityAndRemoveItem() {
        HashSet<GroceryItem> testShoppingListList = testShoppingList.getShoppingList();
        testShoppingList.increaseItemQuantity(testGroceryItem1, 3);
        testShoppingList.decreaseItemQuantity(testGroceryItem1, 3);
        assertEquals(0, testShoppingListList.size());
    }
}
