package model;

import java.util.HashSet;

public class ShoppingList {
    private HashSet<GroceryItem> shoppingList;

    // EFFECTS: constructs user's shopping list with no items
    public ShoppingList() {
        shoppingList = new HashSet<GroceryItem>();
    }

    // MODIFIES: this
    // EFFECTS: adds given grocery item into shopping list
    public void addItem(GroceryItem groceryItem) {
        shoppingList.add(groceryItem);
    }

    // REQUIRES: given grocery item is already in the list
    // MODIFIES: this
    // EFFECTS: removes given grocery item from shopping list
    public void removeItem(GroceryItem groceryItem) {
        shoppingList.remove(groceryItem);
    }

    // REQUIRES: given grocery item is already in the list, amount > 0
    // MODIFIES: groceryItem
    // EFFECTS: increases groceryItem's quantity in shopping list by given amount
    public void increaseItemQuantity(GroceryItem groceryItem, int amount){
        int newQuantity = groceryItem.getQuantityInShoppingList() + amount;
        groceryItem.setQuantityInShoppingList(newQuantity);
    }

    // REQUIRES: given grocery item is already in the list, and groceryItem.getQuantityInShoppingList() >= amount > 0
    // MODIFIES: groceryItem
    // EFFECTS: decreases groceryItem's quantity in shopping list by given amount;
    // if groceryItem's new quantity is 0, remove this item from shopping list
    public void decreaseItemQuantity(GroceryItem groceryItem, int amount){
        int newQuantity = groceryItem.getQuantityInShoppingList() - amount;
        groceryItem.setQuantityInShoppingList(newQuantity);
        if (newQuantity == 0) {
            this.removeItem(groceryItem);
        }
    }

    public HashSet<GroceryItem> getShoppingList() {
        return shoppingList;
    }
}
