package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GroceryListTest {
    protected GroceryList testGroceryList;
    protected GroceryItem testGroceryItem1;
    protected GroceryItem testGroceryItem2;

    @BeforeEach
    void runBefore() {
        testGroceryItem1 = new GroceryItem("milk", "dairy");
        testGroceryItem2 = new GroceryItem("lettuce", "vegetables");
        testGroceryList = new GroceryList();
    }

    @Test
    void testConstructor() {
        assertEquals(0, testGroceryList.getGroceryList().size());
    }

    @Test
    void testAddOneItem() {
        testGroceryList.addItem(testGroceryItem1);
        assertEquals(1, testGroceryList.getGroceryList().size());
    }

    @Test
    void testAddMultipleDifferentItems() {
        HashSet<GroceryItem> testInventoryList = testGroceryList.getGroceryList();
        testGroceryList.addItem(testGroceryItem1);
        assertEquals(1, testInventoryList.size());
        testGroceryList.addItem(testGroceryItem2);
        assertEquals(2, testInventoryList.size());
    }

    @Test
    void testAddSameItemMultipleTimes() {
        HashSet<GroceryItem> testGroceryListHashSet = testGroceryList.getGroceryList();
        testGroceryList.addItem(testGroceryItem1);
        assertEquals(1, testGroceryListHashSet.size());
        testGroceryList.addItem(testGroceryItem1);
        assertEquals(1, testGroceryListHashSet.size());
    }

    @Test
    void testRemoveOneItem() {
        HashSet<GroceryItem> testGroceryListHashSet = testGroceryList.getGroceryList();
        testGroceryList.addItem(testGroceryItem1);
        assertEquals(1, testGroceryListHashSet.size());
        testGroceryList.removeItem(testGroceryItem1);
        assertEquals(0, testGroceryListHashSet.size());
    }

    @Test
    void testRemoveMultipleDifferentItems() {
        HashSet<GroceryItem> testGroceryListHashSet = testGroceryList.getGroceryList();
        testGroceryList.addItem(testGroceryItem1);
        testGroceryList.addItem(testGroceryItem2);
        assertEquals(2, testGroceryListHashSet.size());
        testGroceryList.removeItem(testGroceryItem1);
        assertEquals(1, testGroceryListHashSet.size());
        testGroceryList.removeItem(testGroceryItem2);
        assertEquals(0, testGroceryListHashSet.size());
    }

    @Test
    void testGetItem() {
        testGroceryList.addItem(testGroceryItem1);
        testGroceryList.addItem(testGroceryItem2);
        assertEquals(testGroceryItem1, testGroceryList.getItem(testGroceryItem1.getName()));
    }

    @Test
    void testGetItemNotInList() {
        testGroceryList.addItem(testGroceryItem2);
        assertEquals(null, testGroceryList.getItem(testGroceryItem1.getName()));
    }

}
