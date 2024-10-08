package model;

import java.util.HashSet;

public abstract class GroceryList {
    protected HashSet<GroceryItem> groceryList;

    // EFFECTS: constructs a grocery list with no items
    public GroceryList() {
        groceryList = new HashSet<GroceryItem>();
    }

    // MODIFIES: this
    // EFFECTS: adds given grocery item into inventory list
    public void addItem(GroceryItem groceryItem) {
        groceryList.add(groceryItem);
    }

    // REQUIRES: given grocery item is already in the list
    // MODIFIES: this
    // EFFECTS: removes given grocery item from inventory list
    public void removeItem(GroceryItem groceryItem) {
        groceryList.remove(groceryItem);
    }

    // REQUIRES: given grocery item is already in the list, amount > 0
    // MODIFIES: groceryItem
    // EFFECTS: increases groceryItem's quantity in respective list by given amount
    public abstract void increaseItemQuantity(GroceryItem groceryItem, int amount);

    // REQUIRES: given grocery item is already in the list, and groceryItem.getQuantityInInventory() >= amount > 0
    // MODIFIES: groceryItem
    // EFFECTS: decreases groceryItem's quantity in inventory by given amount;
    // if groceryItem's new quantity is 0, remove this item from inventory
    public abstract void decreaseItemQuantity(GroceryItem groceryItem, int amount);

    public HashSet<GroceryItem> getGroceryList() {
        return groceryList;
    }
}
