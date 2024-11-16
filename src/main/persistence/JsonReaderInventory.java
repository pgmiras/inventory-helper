package persistence;

import org.json.JSONObject;

import model.GroceryList;

public class JsonReaderInventory extends JsonReader {

    public JsonReaderInventory(String source) {
        super(source);
        //TODO Auto-generated constructor stub
    }

    // EFFECTS: parses inventory list from JSON object and returns it
    @Override
    protected GroceryList parseGroceryList(JSONObject jsonObject) {
        GroceryList gl = new GroceryList();
        addItems(gl, jsonObject);
        return gl;
    }
    
}
