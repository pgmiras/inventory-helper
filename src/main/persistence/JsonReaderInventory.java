package persistence;

import org.json.JSONObject;

import model.InventoryList;

public class JsonReaderInventory extends JsonReader {

    public JsonReaderInventory(String source) {
        super(source);
        //TODO Auto-generated constructor stub
    }

    // EFFECTS: parses inventory list from JSON object and returns it
    @Override
    protected InventoryList parseGroceryList(JSONObject jsonObject) {
        InventoryList gl = new InventoryList();
        addItems(gl, jsonObject);
        return gl;
    }
    
}
