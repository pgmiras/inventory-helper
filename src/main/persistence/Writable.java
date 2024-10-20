package persistence;

import org.json.JSONObject;

// Used JsonSerializationDemo as reference to structure this class
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

public interface Writable {
    // EFFECTS: returns this as JSON object
    JSONObject toJson();
}
