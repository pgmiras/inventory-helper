package model;

// Grocery list for items user has yet to purchase
public class ShoppingList extends GroceryList {

    // EFFECTS: constructs a grocery list of list type shopping list
    public ShoppingList() {
        super();
        listType = "shopping list";
    }

}
