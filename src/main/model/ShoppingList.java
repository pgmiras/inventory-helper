package model;

import java.util.HashSet;

// Represents user's shopping list
public class ShoppingList extends GroceryList{

    // EFFECTS: constructs user's shopping list with no items
    public ShoppingList() {
        super();
    }

    // REQUIRES: given grocery item is already in the list, amount > 0
    // MODIFIES: groceryItem
    // EFFECTS: increases groceryItem's quantity in shopping list by given amount
    @Override
    public void increaseItemQuantity(GroceryItem groceryItem, int amount){
        int newQuantity = groceryItem.getQuantityInShoppingList() + amount;
        groceryItem.setQuantityInShoppingList(newQuantity);
    }

    // REQUIRES: given grocery item is already in the list, and groceryItem.getQuantityInShoppingList() >= amount > 0
    // MODIFIES: groceryItem
    // EFFECTS: decreases groceryItem's quantity in shopping list by given amount;
    // if groceryItem's new quantity is 0, remove this item from shopping list
    @Override
    public void decreaseItemQuantity(GroceryItem groceryItem, int amount){
        int newQuantity = groceryItem.getQuantityInShoppingList() - amount;
        groceryItem.setQuantityInShoppingList(newQuantity);
        if (newQuantity == 0) {
            this.removeItem(groceryItem);
        }
    }
}
