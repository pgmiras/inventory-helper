package persistence;
import model.GroceryList;
import org.json.JSONObject;


import java.io.*;

// Used JsonSerializationDemo as reference to structure this class
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Represents a writer that writes JSON representation of grocery list to file
public class JsonWriter {

    // EFFECTS: constructs writer to write to destination file
    public JsonWriter(String destination) {
    }

    // MODIFIES: this
    // EFFECTS: opens writer; throws FileNotFoundException if destination file cannot
    // be opened for writing
    public void open() throws FileNotFoundException {
    }

    // MODIFIES: this
    // EFFECTS: writes JSON representation of grocery list to file
    public void write(GroceryList gl) {
    }

    // MODIFIES: this
    // EFFECTS: closes writer
    public void close() {
    }

    // MODIFIES: this
    // EFFECTS: writes string to file
    private void saveToFile(String json) {
    }
}
