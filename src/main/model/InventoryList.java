package model;

import java.util.ArrayList;
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

    // REQUIRES: given grocery item is already in the list, amount > 0
    // MODIFIES: groceryItem
    // EFFECTS: increases groceryItem's quantity in inventory by given amount
    public void increaseItemQuantity(GroceryItem groceryItem, int amount){
        // TODO stub
    }

    // REQUIRES: given grocery item is already in the list, and groceryItem.getQuantityInInventory() >= amount > 0
    // MODIFIES: groceryItem
    // EFFECTS: decreases groceryItem's quantity in inventory by given amount;
    // if groceryItem's new quantity is 0, remove this item from inventory
    public void decreaseItemQuantity(GroceryItem groceryItem, int amount){
        // TODO stub
    }

    public ArrayList<GroceryItem> getInventoryList() {
        return null; // TODO stub
    }
}
