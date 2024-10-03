package model;

import java.util.List;

public class InventoryList {
    private List<GroceryItem> inventory;

    // EFFECTS: constructs user's inventory with no items
    public InventoryList() {
        // TODO stub
    }

    // MODIFIES: this
    // EFFECTS: adds given grocery item into inventory list
    public void addItem(GroceryItem groceryItem) {
        // TODO stub
    }

    // REQUIRES: given grocery item is already in the list
    // MODIFIES: this
    // EFFECTS: removes given grocery item from inventory list
    public void removeItem(GroceryItem groceryItem) {
        // TODO stub
    }

    // REQUIRES: given grocery item is already in the list
    // MODIFIES: groceryItem
    // EFFECTS: increases groceryItem's quantity in inventory by given amount
    public void increaseItemQuantity(GroceryItem groceryItem, int amount){
        // TODO stub
    }

    // REQUIRES: given grocery item is already in the list, and groceryItem.getQuantityInInventory() >= amount
    // MODIFIES: groceryItem
    // EFFECTS: decreases groceryItem's quantity in inventory by given amount
    public void dereaseItemQuantity(GroceryItem groceryItem, int amount){
        // TODO stub
    }
}
