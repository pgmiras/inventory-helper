package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryListTest extends GroceryListTest {
    @BeforeEach
    @Override
    void runBefore() {
        super.runBefore();
        testGroceryList = new InventoryList();
    }

    @Test
    @Override
    void testGetItem(){
        testGroceryList.addItem(testGroceryItem1);
        testGroceryList.addItem(testGroceryItem2);
        assertEquals(testGroceryItem1, testGroceryList.getItem(testGroceryItem1.getName()));
    }
}
