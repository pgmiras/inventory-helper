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
    public void increaseQuantityInInventory(int amount) {
        quantityInInventory += amount;
    }

    // REQUIRES: given grocery item is already in user's list, and
    // getQuantityInInventory() >= amount > 0
    // MODIFIES: this
    // EFFECTS: decreases grocery item's quantity in inventory by given amount;
    public void decreaseQuantityInInventory(int amount) {
        quantityInInventory -= amount;
    }

    // REQUIRES: given grocery item is already in user's shopping list, amount > 0
    // MODIFIES: this
    // EFFECTS: increases grocery item's quantity in shopping list by given amount
    public void increaseQuantityInShoppingList(int amount) {
        quantityInShoppingList += amount;
    }

    // REQUIRES: given grocery item is already in user's shopping list, and
    // getQuantityInShoppingList() >= amount > 0
    // MODIFIES: this
    // EFFECTS: decreases grocery item's quantity in shopping by given amount
    public void decreaseQuantityInShoppingList(int amount) {
        quantityInShoppingList -= amount;
    }

    // EFFECTS: indicates if grocery item is contained in inventory list
    public boolean isContainedInInventoryList() {
        if (quantityInInventory > 0) {
            return true;
        } else {
            return false;
        }
    }

    // EFFECTS: indicates if grocery item is contained in shopping list
    public boolean isContainedInShoppingList() {
        if (quantityInShoppingList > 0) {
            return true;
        } else {
            return false;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getQuantityInInventory() {
        return this.quantityInInventory;
    }

    public int getQuantityInShoppingList() {
        return this.quantityInShoppingList;
    }

    public String getCategory() {
        return this.category;
    }
}
