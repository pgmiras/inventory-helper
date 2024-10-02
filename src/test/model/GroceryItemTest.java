package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GroceryItemTest {
    private GroceryItem testGroceryItem;

    @BeforeEach
    void runBefore() {
        testGroceryItem = new GroceryItem("milk", 1, "dairy");
    }

    @Test
    void testConstructor() {
        assertEquals("milk", testGroceryItem.getName());
        assertEquals(1, testGroceryItem.getQuantity());
        assertEquals("dairy", testGroceryItem.getCategory());
    }
}
