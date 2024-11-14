package ui.screens;

import javax.swing.*;

import model.*;
import persistence.*;
import ui.screens.tools.*;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.Scanner;

// Used TellerApp as reference
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/TellerApp

// Used JsonSerializationDemo as reference
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Used SimpleDrawingPlayer as reference
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Starter

// Represents application's main window frame
public class InventoryAppUI extends JFrame {
    private static final int WIDTH = 750;
    private static final int HEIGHT = 500;

    private JPanel mainPanel;
    private MenuUI inventoryMenu;
    private MenuUI shoppingListMenu;

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
    public InventoryAppUI() {
        super("My Inventory");

        input = new Scanner(System.in);

        jsonWriterInventory = new JsonWriter(JSON_STORE_INVENTORY);
        jsonReaderInventory = new JsonReader(JSON_STORE_INVENTORY);
        jsonWriterShopping = new JsonWriter(JSON_STORE_SHOPPING);
        jsonReaderShopping = new JsonReader(JSON_STORE_SHOPPING);

        inventory = new InventoryList();
        shoppingList = new ShoppingList();

        initializeGraphics();
    }

    // Used SimpleDrawingPlayer as reference (see repository URL above)
    // MODIFIES: this
    // EFFECTS: draws the starting JFrame window
    private void initializeGraphics() {
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        displayMenuBar();
        displayMainPanel();
        displayInventoryMenu();
        displayShoppingListMenu();

        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: adds the menu bar at the top of the frame
    private void displayMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu saveMenu = new JMenu("Save");
        JMenu loadMenu = new JMenu("Load");
        menuBar.add(saveMenu);
        menuBar.add(loadMenu);

        SaveInventoryTool saveInventoryMenu = new SaveInventoryTool(this, saveMenu);
        SaveShoppingListTool saveShoppingListTool = new SaveShoppingListTool(this, saveMenu);
        SaveBothTool saveBothMenu = new SaveBothTool(this, saveMenu);

        setJMenuBar(menuBar);
        // TODO
    }

    // MODIFIES: this
    // EFFECTS: adds the main panel
    private void displayMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2));
        add(mainPanel);
    }

    // MODIFIES: this
    // EFFECTS: adds the panel for the inventory menu
    private void displayInventoryMenu() {
        inventoryMenu = new MenuUI(inventory, this);
        mainPanel.add(inventoryMenu);
    }

    // MODIFIES: this
    // EFFECTS: adds the panel for the shopping list menu
    private void displayShoppingListMenu() {
        shoppingListMenu = new MenuUI(shoppingList, this);
        mainPanel.add(shoppingListMenu);
    }

    // REQUIRES: listType is either "inventory" or "shopping list"
    // EFFECTS: saves the grocery list to file
    public void saveGroceryList(String listType) {
        JsonWriter jsonWriter = new JsonWriter("");
        String jsonStore = "";
        GroceryList gl = new GroceryList();
        if (listType.equals("inventory")) {
            jsonWriter = jsonWriterInventory;
            jsonStore = JSON_STORE_INVENTORY;
            gl = inventory;
        } else if (listType.equals("shopping list")) {
            jsonWriter = jsonWriterShopping;
            jsonStore = JSON_STORE_SHOPPING;
            gl = shoppingList;
        }
        try {
            jsonWriter.open();
            jsonWriter.write(gl);
            jsonWriter.close();
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Unable to write to file: " + jsonStore,
                    "Save Unsuccessful",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public int getUserInterfaceWidth() {
        return WIDTH;
    }

    public int getUserInterfaceHeight() {
        return HEIGHT;
    }
}
