package persistence;

import org.json.JSONObject;

import model.GroceryList;
import model.ShoppingList;

public class JsonReaderShopping extends JsonReader {

    public JsonReaderShopping(String source) {
        super(source);
        //TODO Auto-generated constructor stub
    }

    // EFFECTS: parses shopping list from JSON object and returns it
    @Override
    protected ShoppingList parseGroceryList(JSONObject jsonObject) {
        GroceryList gl = new GroceryList();
        addItems(gl, jsonObject);
        return gl;
    }
    
}
