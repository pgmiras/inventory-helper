package persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import model.GroceryList;

public class JsonReaderShoppingTest extends JsonReaderTest {
    @Test
    void testReaderShoppingList() {
        JsonReaderShopping reader = new JsonReaderShopping("./data/testReaderShoppingList.json");
        try {
            GroceryList gl = reader.read();
            assertEquals("shopping list", gl.getListType());
            assertEquals(3, gl.getGroceryList().size());
            checkGroceryItem("carrot", 0, 5, "vegetables", gl.getItem("carrot"));
            checkGroceryItem("honey", 0, 4, "sweeteners", gl.getItem("honey"));
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
