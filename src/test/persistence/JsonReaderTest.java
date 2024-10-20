package persistence;

import model.GroceryList;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

// Used JsonSerializationDemo as reference to structure this class
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

class JsonReaderTest extends JsonTest {

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/noSuchFile.json");
        try {
            GroceryList gl = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // expected
        }
    }

    @Test
    void testReaderEmptyGroceryList() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyGroceryList.json");
        try {
            GroceryList gl = reader.read();
            assertEquals(0, gl.getGroceryList().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralGroceryList() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralGroceryList.json");
        try {
            GroceryList gl = reader.read();
            assertEquals(3, gl.getGroceryList().size());
            checkGroceryItem("milk", 3, 2, "dairy", gl.getItem("milk"));
            checkGroceryItem("carrot", 2, 0, "vegetables", gl.getItem("carrot"));
            checkGroceryItem("apple", 0, 4, "fruits", gl.getItem("apple"));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}