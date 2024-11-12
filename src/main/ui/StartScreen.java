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
    private static final int WIDTH = 750;
	private static final int HEIGHT = 500;
    
    private JPanel mainPanel;

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

        setJMenuBar(menuBar);
        // TODO
    }

    // MODIFIES: this
    // EFFECTS:  adds the main panel
    private void displayMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 2));
        add(mainPanel);
    }

    // MODIFIES: this
    // EFFECTS:  adds the panel for the inventory menu
    private void displayInventoryMenu() {
        MenuUI inventoryMenu = new MenuUI("inventory", this);
        mainPanel.add(inventoryMenu);
    }

    // MODIFIES: this
    // EFFECTS:  adds the panel for the shopping list menu
    private void displayShoppingListMenu() {
        MenuUI shoppingListMenu = new MenuUI("shopping list", this);
        mainPanel.add(shoppingListMenu);
    }

    public int getUserInterfaceWidth() {
        return WIDTH;
    }

    public int getUserInterfaceHeight() {
        return HEIGHT;
    }
}
