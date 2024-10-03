package model;

public class GroceryItem {
    private String name;
    private int quantityInInventory;
    private int quantityInShoppingList;
    private String category;

    // REQUIRES: name has non-zero length, quantity > 0, category has non-zero length
    // EFFECTS: constructs a new grocery item with given name, and category,
    // and its quantity in either user's inventory or shopping list depends on whether user wants to add
    // this new grocery item into their inventory or shopping list; otherwise, it is not in the other list
    public GroceryItem(String name, int quantity, String category, boolean isToBeAddedToInventory) {
        this.name = name;
        if (isToBeAddedToInventory) {
            this.quantityInInventory = quantity;
            this.quantityInShoppingList = 0;
        } else {
            this.quantityInInventory = 0;
            this.quantityInShoppingList = quantity;
        }
        this.category = category;
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

    public void setQuantityInInventory(int quantityInInventory){
        this.quantityInInventory = quantityInInventory;
    }

    public void setQuantityInShoppingList(int quantityInShoppingList){
        this.quantityInShoppingList = quantityInShoppingList;
    }

    public void setCategory(String category){
        this.category = category;
    }
}
