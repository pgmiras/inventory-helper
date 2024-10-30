package ui;

import javax.swing.*;

import model.GroceryList;
import persistence.JsonReader;
import persistence.JsonWriter;
import ui.screens.*;

import java.awt.*;
import java.util.Scanner;

// Used TellerApp as reference
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/TellerApp

// Used JsonSerializationDemo as reference
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Used SimpleDrawingPlayer as reference
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Starter

// Represents application's main window frame
public class StartScreen extends JFrame {
    public static final int WIDTH = 1000;
	public static final int HEIGHT = 700;
    public GridBagConstraints gbc;

    private Scanner input;

    private static final String JSON_STORE_INVENTORY = "./data/inventory.json";
    private static final String JSON_STORE_SHOPPING = "./data/shoppinglist.json";
    private JsonWriter jsonWriterInventory;
    private JsonReader jsonReaderInventory;
    private JsonWriter jsonWriterShopping;
    private JsonReader jsonReaderShopping;

    private GroceryList inventory;
    private GroceryList shoppingList;

    // Used TellerApp as reference (see repository URL above)
    // EFFECTS: runs the inventory application
    public StartScreen() {
        super("Your Inventory");

        input = new Scanner(System.in);

        jsonWriterInventory = new JsonWriter(JSON_STORE_INVENTORY);
        jsonReaderInventory = new JsonReader(JSON_STORE_INVENTORY);
        jsonWriterShopping = new JsonWriter(JSON_STORE_SHOPPING);
        jsonReaderShopping = new JsonReader(JSON_STORE_SHOPPING);

        inventory = new GroceryList();
        shoppingList = new GroceryList();

        initializeGraphics();
    }

    // Used SimpleDrawingPlayer as reference (see repository URL above)
    // MODIFIES: this
    // EFFECTS:  draws the starting JFrame window
    private void initializeGraphics() {
        setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        displayInventoryMenu();
        displayShoppingListMenu();
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS:  adds the panel for the inventory menu
    private void displayInventoryMenu() {
        MenuUI inventoryMenu = new MenuUI("inventory", this);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(inventoryMenu, gbc);
    }

    // MODIFIES: this
    // EFFECTS:  adds the panel for the shopping list menu
    private void displayShoppingListMenu() {
        MenuUI shoppingListMenu = new MenuUI("shopping list", this);
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(shoppingListMenu, gbc);
    }

    public int getUserInterfaceWidth() {
        return WIDTH;
    }

    public int getUserInterfaceHeight() {
        return HEIGHT;
    }
}
