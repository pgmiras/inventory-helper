package model;

import java.util.HashSet;

public class GroceryList {
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

    public HashSet<GroceryItem> getGroceryList() {
        return groceryList;
    }
}
