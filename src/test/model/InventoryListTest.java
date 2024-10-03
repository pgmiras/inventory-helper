package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryListTest {
    private InventoryList testInventory;
    private GroceryItem testGroceryItem1;
    private GroceryItem testGroceryItem2;

    @BeforeEach
    void runBefore() {
        testInventory = new InventoryList();
        testGroceryItem1 = new GroceryItem("milk", "dairy");
        testGroceryItem2 = new GroceryItem("lettuce", "vegetables");
    }

    @Test
    void testConstructor() {
        ArrayList<GroceryItem> testInventoryList = testInventory.getInventoryList();
        assertEquals(0, testInventoryList.size());
    }

    @Test
    void testAddOneItem() {
        ArrayList<GroceryItem> testInventoryList = testInventory.getInventoryList();
        testInventory.addItem(testGroceryItem1);
        assertEquals(1, testInventoryList.size());
        assertEquals(testGroceryItem1, testInventoryList.get(0));
    }

    @Test
    void testAddMultipleDifferentItems() {
        ArrayList<GroceryItem> testInventoryList = testInventory.getInventoryList();
        testInventory.addItem(testGroceryItem1);
        assertEquals(1, testInventoryList.size());
        testInventory.addItem(testGroceryItem2);
        assertEquals(2, testInventoryList.size());
        assertEquals(testGroceryItem1, testInventoryList.get(0));
        assertEquals(testGroceryItem2, testInventoryList.get(1));
    }    

    @Test
    void testAddSameItemMultipleTimes() {
        ArrayList<GroceryItem> testInventoryList = testInventory.getInventoryList();
        testInventory.addItem(testGroceryItem1);
        assertEquals(1, testInventoryList.size());
        testInventory.addItem(testGroceryItem1);
        assertEquals(1, testInventoryList.size());
        assertEquals(testGroceryItem1, testInventoryList.get(0));
    }    

    @Test
    void testRemoveOneItem() {
        ArrayList<GroceryItem> testInventoryList = testInventory.getInventoryList();
        testInventory.addItem(testGroceryItem1);
        assertEquals(1, testInventoryList.size());
        assertEquals(testGroceryItem1, testInventoryList.get(0));
        testInventory.removeItem(testGroceryItem1);
        assertEquals(0, testInventoryList.size());
    }

    @Test
    void testRemoveMultipleDifferentItems() {
        ArrayList<GroceryItem> testInventoryList = testInventory.getInventoryList();
        testInventory.addItem(testGroceryItem1);
        testInventory.addItem(testGroceryItem2);
        assertEquals(2, testInventoryList.size());
        testInventory.removeItem(testGroceryItem1);
        assertEquals(1, testInventoryList.size());
        assertEquals(testGroceryItem2, testInventoryList.get(0));
        testInventory.removeItem(testGroceryItem2);
        assertEquals(0, testInventoryList.size());
    }

    @Test
    void testIncreaseItemQuantity() {
        testInventory.increaseItemQuantity(testGroceryItem1, 2);
        assertEquals(2, testGroceryItem1.getQuantityInInventory());
    }

    @Test
    void testDecreaseItemQuantity() {
        testInventory.increaseItemQuantity(testGroceryItem1, 3);
        testInventory.decreaseItemQuantity(testGroceryItem1, 2);
        assertEquals(1, testGroceryItem1.getQuantityInInventory());
    }

    @Test
    void testDecreaseItemQuantityAndRemoveItem() {
        ArrayList<GroceryItem> testInventoryList = testInventory.getInventoryList();
        testInventory.increaseItemQuantity(testGroceryItem1, 3);
        testInventory.decreaseItemQuantity(testGroceryItem1, 3);
        assertEquals(0, testInventoryList.size());
    }
}
