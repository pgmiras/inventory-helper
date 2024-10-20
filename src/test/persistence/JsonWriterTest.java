package persistence;

import model.GroceryItem;
import model.GroceryList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Used JsonSerializationDemo as reference to structure this class
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

class JsonWriterTest extends JsonTest {
    GroceryList gl;

    @BeforeEach
    void runBefore() {
        gl = new GroceryList();
    }

    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // expected
        }
    }

    @Test
    void testWriterEmptyGroceryList() {
        try {
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyGroceryList.json");
            writer.open();
            writer.write(gl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyGroceryList.json");
            gl = reader.read();
            assertEquals(0, gl.getGroceryList().size());
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }

    @Test
    void testWriterGeneralGroceryList() {
        try {
            gl.addItem(new GroceryItem("saw", 1, 0, "tools"));
            gl.addItem(new GroceryItem("cabbage", 3, 2, "vegetables"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralGroceryList.json");
            writer.open();
            writer.write(gl);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralGroceryList.json");
            gl = reader.read();
            assertEquals(2, gl.getGroceryList().size());
            checkGroceryItem("saw", 1, 0, "tools", gl.getItem("saw"));
            checkGroceryItem("cabbage", 3, 2, "vegetables", gl.getItem("cabbage"));
        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}