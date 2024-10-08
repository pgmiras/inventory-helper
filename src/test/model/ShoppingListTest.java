package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShoppingListTest extends GroceryListTest {

    @BeforeEach
    @Override
    void runBefore() {
        super.runBefore();
        testGroceryList = new ShoppingList();
    }

    @Test
    @Override
    void testIncreaseItemQuantity() {
        // TODO
    }

    @Test
    @Override
    void testDecreaseItemQuantity() {
        // TODO
    }

    @Test
    @Override
    void testDecreaseItemQuantityAndRemoveItem() {
        // TODO
    }
}
