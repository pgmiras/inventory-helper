package model;

// Grocery list for items user already has
public class InventoryList extends GroceryList {
    
    // EFFECTS: constructs a grocery list of list type inventory
    public InventoryList() {
        super();
        listType = "inventory";
    }

}
