package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InventoryListTest extends GroceryListTest {

    @BeforeEach
    void runBefore() {
        testGroceryList = new InventoryList();
    }

    @Test
    void testConstructor() {
        super.testConstructor();
        assertEquals("inventory", testGroceryList.getListType());
    }
}
