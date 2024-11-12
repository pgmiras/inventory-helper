package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShoppingListTest extends GroceryListTest {

    @BeforeEach
    void runBefore() {
        super.runBefore();
        testGroceryList = new ShoppingList();
    }

    @Test
    void testConstructor() {
        super.testConstructor();
        assertEquals("shopping list", testGroceryList.getListType());
    }
}
