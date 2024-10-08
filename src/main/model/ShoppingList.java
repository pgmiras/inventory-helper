package model;

// Represents user's shopping list
public class ShoppingList extends GroceryList{

    // EFFECTS: constructs user's shopping list with no items
    public ShoppingList() {
        super();
    }

    @Override
    public void increaseItemQuantity(GroceryItem groceryItem, int amount){
        groceryItem.increaseQuantityInShoppingList(amount);
    }

    @Override
    public void decreaseItemQuantity(GroceryItem groceryItem, int amount){
        groceryItem.decreaseQuantityInShoppingList(amount);
        if (groceryItem.getQuantityInInventory() == 0) {
            this.removeItem(groceryItem);
        }
    }
}
