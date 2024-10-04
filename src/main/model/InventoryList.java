package model;

import java.util.HashSet;

// Represents user's inventory
public class InventoryList {
    private HashSet<GroceryItem> inventory;

    // EFFECTS: constructs user's inventory with no items
    public InventoryList() {
        inventory = new HashSet<GroceryItem>();
    }

    // MODIFIES: this
    // EFFECTS: adds given grocery item into inventory list
    public void addItem(GroceryItem groceryItem) {
        inventory.add(groceryItem);
    }

    // REQUIRES: given grocery item is already in the list
    // MODIFIES: this
    // EFFECTS: removes given grocery item from inventory list
    public void removeItem(GroceryItem groceryItem) {
        inventory.remove(groceryItem);
    }

    // REQUIRES: given grocery item is already in the list, amount > 0
    // MODIFIES: groceryItem
    // EFFECTS: increases groceryItem's quantity in inventory by given amount
    public void increaseItemQuantity(GroceryItem groceryItem, int amount){
        int newQuantity = groceryItem.getQuantityInInventory() + amount;
        groceryItem.setQuantityInInventory(newQuantity);
    }

    // REQUIRES: given grocery item is already in the list, and groceryItem.getQuantityInInventory() >= amount > 0
    // MODIFIES: groceryItem
    // EFFECTS: decreases groceryItem's quantity in inventory by given amount;
    // if groceryItem's new quantity is 0, remove this item from inventory
    public void decreaseItemQuantity(GroceryItem groceryItem, int amount){
        int newQuantity = groceryItem.getQuantityInInventory() - amount;
        groceryItem.setQuantityInInventory(newQuantity);
        if (newQuantity == 0) {
            this.removeItem(groceryItem);
        }
    }

    public HashSet<GroceryItem> getInventoryList() {
        return inventory;
    }
}
