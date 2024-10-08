package model;

// Represents a grocery item describing its name, how many of it is in user's inventory,
// how many of it is in user's shopping list, and its category
public class GroceryItem {
    private String name;
    private int quantityInInventory;
    private int quantityInShoppingList;
    private String category;

    // REQUIRES: name and category have non-zero length
    // EFFECTS: constructs a new grocery item with given name and category,
    // and its quantities in user's inventory and shopping list are zero
    public GroceryItem(String name, String category) {
        this.name = name;
        this.quantityInInventory = 0;
        this.quantityInShoppingList = 0;
        this.category = category;
    }

    // REQUIRES: given grocery item is already in user's inventory, amount > 0
    // MODIFIES: this
    // EFFECTS: increases grocery item's quantity in inventory by given amount
    public void increaseQuantityInInventory(int amount){
        // TODO
    }

    // REQUIRES: given grocery item is already in user's list, and getQuantityInInventory() >= amount > 0
    // MODIFIES: this
    // EFFECTS: decreases grocery item's quantity in inventory by given amount;
    // if grocery item's new quantity is 0, remove this item from inventory    
    public void decreaseQuantityInInventory(int amount){
        // TODO
    }

    // REQUIRES: given grocery item is already in user's inventory, amount > 0
    // MODIFIES: this
    // EFFECTS: increases grocery item's quantity in inventory by given amount
    public void increaseQuantityInShoppingList(int amount){
        // TODO
    }

    // REQUIRES: given grocery item is already in user's list, and getQuantityInInventory() >= amount > 0
    // MODIFIES: this
    // EFFECTS: decreases grocery item's quantity in inventory by given amount;
    // if grocery item's new quantity is 0, remove this item from inventory    
    public void decreaseQuantityInShoppingList(int amount){
        // TODO
    }

    public String getName(){
        return this.name;
    }

    public int getQuantityInInventory(){
        return this.quantityInInventory;
    }

    public int getQuantityInShoppingList(){
        return this.quantityInShoppingList;
    }

    public String getCategory(){
        return this.category;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCategory(String category){
        this.category = category;
    }
}
