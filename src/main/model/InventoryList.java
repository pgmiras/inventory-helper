package model;

import java.util.HashSet;

// Represents user's inventory
public class InventoryList extends GroceryList {
    
    // EFFECTS: constructs user's inventory with no items
    public InventoryList() {
        super();
    }

    // REQUIRES: given grocery item is already in the list, amount > 0
    // MODIFIES: groceryItem
    // EFFECTS: increases groceryItem's quantity in inventory by given amount
    @Override
    public void increaseItemQuantity(GroceryItem groceryItem, int amount){
        int newQuantity = groceryItem.getQuantityInInventory() + amount;
        groceryItem.setQuantityInInventory(newQuantity);
    }

    // REQUIRES: given grocery item is already in the list, and groceryItem.getQuantityInInventory() >= amount > 0
    // MODIFIES: groceryItem
    // EFFECTS: decreases groceryItem's quantity in inventory by given amount;
    // if groceryItem's new quantity is 0, remove this item from inventory
    @Override
    public void decreaseItemQuantity(GroceryItem groceryItem, int amount){
        int newQuantity = groceryItem.getQuantityInInventory() - amount;
        groceryItem.setQuantityInInventory(newQuantity);
        if (newQuantity == 0) {
            this.removeItem(groceryItem);
        }
    }
}
