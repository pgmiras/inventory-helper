package persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import model.GroceryList;

public class JsonReaderInventoryTest extends JsonReaderTest {
    @Test
    void testReaderInventoryList() {
        JsonReader reader = new JsonReader("./data/testReaderInventoryList.json");
        try {
            GroceryList gl = reader.read();
            assertEquals("inventory", gl.getListType());
            assertEquals(3, gl.getGroceryList().size());
            checkGroceryItem("milk", 3, 2, "dairy", gl.getItem("milk"));
            checkGroceryItem("carrot", 2, 0, "vegetables", gl.getItem("carrot"));
            checkGroceryItem("apple", 0, 4, "fruits", gl.getItem("apple"));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
