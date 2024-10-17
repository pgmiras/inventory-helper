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

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        // TODO
    }

    // EFFECTS: reads grocery list from file and returns it;
    // throws IOException if an error occurs reading data from file
    public GroceryList read() throws IOException {
        return null; // TODO
    }

    // EFFECTS: parses grocery list from JSON object and returns it
    private GroceryList parseGroceryList(JSONObject jsonObject) {
        return null; // TODO
    }

    // MODIFIES: gl
    // EFFECTS: parses grocery items from JSON object and adds them to grocery list
    private void addItems(GroceryList gl, JSONObject jsonObject) {
        // TODO
    }

    // MODIFIES: gl
    // EFFECTS: parses grocery item from JSON object and adds it to grocery list
    private void addGroceryItem(GroceryList gl, JSONObject jsonObject) {
        // TODO
    }
}
