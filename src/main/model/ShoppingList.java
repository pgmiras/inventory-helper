package model;

import java.util.HashSet;

public class ShoppingList {
    private HashSet<GroceryItem> shoppingList;

    // EFFECTS: constructs user's shopping list with no items
    public ShoppingList() {
        // TODO 
    }

    // MODIFIES: this
    // EFFECTS: adds given grocery item into shopping list
    public void addItem(GroceryItem groceryItem) {
        // TODO
    }

    // REQUIRES: given grocery item is already in the list
    // MODIFIES: this
    // EFFECTS: removes given grocery item from shopping list
    public void removeItem(GroceryItem groceryItem) {
        // TODO
    }

    // REQUIRES: given grocery item is already in the list, amount > 0
    // MODIFIES: groceryItem
    // EFFECTS: increases groceryItem's quantity in shopping list by given amount
    public void increaseItemQuantity(GroceryItem groceryItem, int amount){
        // TODO
    }

    // REQUIRES: given grocery item is already in the list, and groceryItem.getQuantityInShoppingList() >= amount > 0
    // MODIFIES: groceryItem
    // EFFECTS: decreases groceryItem's quantity in shopping list by given amount;
    // if groceryItem's new quantity is 0, remove this item from shopping list
    public void decreaseItemQuantity(GroceryItem groceryItem, int amount){
        // TODO
    }

    public HashSet<GroceryItem> getShoppingList() {
        return null; // TODO
    }
}
