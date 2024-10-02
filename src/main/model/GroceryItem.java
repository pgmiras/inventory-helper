package model;

public class GroceryItem {
    private String name;
    private int quantity;
    private String category;

    // REQUIRES: name has non-zero length, quantity > 0, category has non-zero length
    // EFFECTS: constructs a grocery item with given name, quantity, and category
    public GroceryItem(String name, int quantity, String category) {
        this.name = name;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName(){
        return this.name;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public String getCategory(){
        return this.category;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }

    public void setCategory(String category){
        this.category = category;
    }
}
