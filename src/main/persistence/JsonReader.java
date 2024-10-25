package persistence;

import model.GroceryItem;
import model.GroceryList;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Used JsonSerializationDemo as reference to structure this class
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Represents a reader that reads grocery list from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads grocery list from file and returns it;
    // throws IOException if an error occurs reading data from file
    public GroceryList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseGroceryList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses grocery list from JSON object and returns it
    private GroceryList parseGroceryList(JSONObject jsonObject) {
        GroceryList gl = new GroceryList();
        addItems(gl, jsonObject);
        return gl;
    }

    // MODIFIES: gl
    // EFFECTS: parses grocery items from JSON object and adds them to grocery list
    private void addItems(GroceryList gl, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("groceryList");
        for (Object json : jsonArray) {
            JSONObject nextItem = (JSONObject) json;
            addGroceryItem(gl, nextItem);
        }
    }

    // MODIFIES: gl
    // EFFECTS: parses grocery item from JSON object and adds it to grocery list
    private void addGroceryItem(GroceryList gl, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        int quantityInInventory = jsonObject.getInt("quantityInInventory");
        int quantityInShoppingList = jsonObject.getInt("quantityInShoppingList");
        String category = jsonObject.getString("category");
        GroceryItem groceryItem = new GroceryItem(name, category);
        groceryItem.increaseQuantityInInventory(quantityInInventory);
        groceryItem.increaseQuantityInShoppingList(quantityInShoppingList);
        gl.addItem(groceryItem);
    }
}
