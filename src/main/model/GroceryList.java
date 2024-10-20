package model;

import java.util.HashSet;

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Writable;

// Used JsonSerializationDemo as reference to structure some methods
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public class GroceryList implements Writable {
    protected HashSet<GroceryItem> groceryList;

    // EFFECTS: constructs a grocery list with no items
    public GroceryList() {
        groceryList = new HashSet<GroceryItem>();
    }

    // MODIFIES: this
    // EFFECTS: adds given grocery item into inventory list
    public void addItem(GroceryItem groceryItem) {
        groceryList.add(groceryItem);
    }

    // REQUIRES: given grocery item is already in the list
    // MODIFIES: this
    // EFFECTS: removes given grocery item from inventory list
    public void removeItem(GroceryItem groceryItem) {
        groceryList.remove(groceryItem);
    }

    // REQUIRES: given name is the name of an item that exists in the list
    // EFFECTS: returns item with the given name
    public GroceryItem getItem(String name) {
        for (GroceryItem groceryItem : groceryList) {
            if (name.equals(groceryItem.getName())) {
                return groceryItem;
            }
        }
        return null;
    }

    public HashSet<GroceryItem> getGroceryList() {
        return groceryList;
    }

    // Used JsonSerializationDemo as reference (see URL above)
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("groceryList", thingiesToJson());
        return json;
    }

    // Used JsonSerializationDemo as reference (see URL above)
    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray thingiesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (GroceryItem i : groceryList) {
            jsonArray.put(i.toJson());
        }

        return jsonArray;
    }

}
