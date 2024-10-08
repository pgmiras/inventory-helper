package model;

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
