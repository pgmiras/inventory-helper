package model;

// Represents user's inventory
public class InventoryList extends GroceryList {
    
    // EFFECTS: constructs user's inventory with no items
    public InventoryList() {
        super();
    }

    @Override
    public void increaseItemQuantity(GroceryItem groceryItem, int amount){
        groceryItem.increaseQuantityInInventory(amount);
    }

    @Override
    public void decreaseItemQuantity(GroceryItem groceryItem, int amount){
        groceryItem.decreaseQuantityInInventory(amount);
        if (groceryItem.getQuantityInInventory() == 0) {
            this.removeItem(groceryItem);
        }
    }
}
