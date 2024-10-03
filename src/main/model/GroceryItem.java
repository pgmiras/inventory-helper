package model;

public class GroceryItem {
    private String name;
    private int quantityInInventory;
    private int quantityInShoppingList;
    private String category;

    // REQUIRES: name has non-zero length, quantityInInventory > 0, category has non-zero length
    // EFFECTS: constructs a new grocery item with given name, quantity in user's inventory, and category,
    // and is NOT in user's shopping list
    public GroceryItem(String name, int quantityInInventory, int quantityInShoppingList, String category) {
        this.name = name;
        this.quantityInInventory = quantityInInventory;
        this.quantityInShoppingList = 0;
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
