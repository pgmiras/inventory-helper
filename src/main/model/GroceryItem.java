package model;

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
