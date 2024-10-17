package ui;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;

import model.GroceryItem;
import model.GroceryList;
import persistence.JsonReader;
import persistence.JsonWriter;

// Used TellerApp as reference to structure this class and some methods
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/TellerApp

// Used JsonSerializationDemo as reference to structure this class and some methods
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo

// Inventory application
public class InventoryApp {
    private static final String JSON_STORE = "./data/grocerylist.json";
    private Scanner input;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private GroceryList inventory;
    private GroceryList shoppingList;

    // Used TellerApp as reference (see repository URL above)
    // EFFECTS: runs the inventory application
    public InventoryApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        inventory = new GroceryList();
        shoppingList = new GroceryList();
        runInventoryApp();
    }
    // Used TellerApp as reference (see repository URL above)
    // MODIFIES: this
    // EFFECTS: processes user input
    public void runInventoryApp() {
        boolean keepGoing = true;
        String command = null;

        while (keepGoing) {
            displayMenu();
            command = input.next();
            if (command.equals("z")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }

        System.out.println("Thanks for using the Inventory Application!");
    }

    // Used TellerApp as reference (see repository URL above)
    // EFFECTS: display menu of options to user
    public void displayMenu() {
        printDivider();
        System.out.println("Select from:");
        System.out.println("\ta -> View inventory");
        System.out.println("\tb -> Add to inventory");
        System.out.println("\tc -> Increase specific item in inventory");
        System.out.println("\td -> Decrease specific item in inventory");
        System.out.println("\te -> View shopping list");
        System.out.println("\tf -> Add to shopping list");
        System.out.println("\tg -> Increase specific item in shopping list");
        System.out.println("\th -> Decrease specific item in shopping list");
        System.out.println("\tsi -> Save inventory to file");
        System.out.println("\tli -> Load inventory from file");
        System.out.println("\tss -> Save shopping list to file");
        System.out.println("\tls -> Load shopping list from file");
        System.out.println("\tz -> Quit");
    }

    // Used TellerApp as reference (see repository URL above)
    // REQUIRES: command has non-zero length
    // MODIFIES: this
    // EFFECTS: processes user command
    public void processCommand(String command) {
        if (command.equals("a")) {
            displayInventory();
        } else if (command.equals("b")) {
            addToInventory();
        } else if (command.equals("c")) {
            increaseItemInInventory();
        } else if (command.equals("d")) {
            decreaseItemInInventory();
        } else if (command.equals("e")) {
            displayShoppingList();
        } else if (command.equals("f")) {
            addToShoppingList();
        } else if (command.equals("g")) {
            increaseItemInShoppingList();
        } else if (command.equals("h")) {
            decreaseItemInShoppingList();
        } else if (command.equals("si")) {
            // TODO
        } else if (command.equals("li")) {
            // TODO
        } else if (command.equals("ss")) {
            // TODO
        } else if (command.equals("ls")) {
            // TODO
        }
    }

    // EFFECTS: display user's inventory
    public void displayInventory() {
        printDivider();
        HashSet<GroceryItem> inventoryList = inventory.getGroceryList();
        if (inventoryList.size() == 0) {
            System.out.println("You do not have any items in your inventory.");
        } else {
            System.out.println("You have the following in your inventory:");
            for (GroceryItem i : inventoryList) {
                System.out.println("\t" + i.getQuantityInInventory() 
                                + " " + i.getName() 
                                + " (" + i.getCategory() + ")");
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: allows user to add items to inventory
    public void addToInventory() {
        System.out.println("Is this a new item? (y/n)");
        String userInput = input.next();
        if (userInput.equals("y")) {
            System.out.println("Enter the name of the item you want to add to your inventory:");
            String name = input.next();
            System.out.println("Enter its category:");
            String category = input.next();
            System.out.println("Enter quantity:");
            int quantity = input.nextInt();
            GroceryItem groceryItem = new GroceryItem(name, category);
            groceryItem.increaseQuantityInInventory(quantity);
            inventory.addItem(groceryItem);
        } else {
            System.out.println("Please select \'Increase/Decrease specific item in inventory\' instead.");
        }
    }

    // REQUIRES: given grocery item must be in inventory
    // MODIFIES: this, groceryItem
    // EFFECTS: allows user to increase quantity of items already inside inventory
    public void increaseItemInInventory() {
        displayInventory();
        System.out.println("Which of these items would you like to increase? Enter its name:");
        String name = input.next();
        System.out.println("How many of this item would you like to increase to your inventory?");
        int amount = Integer.parseInt(input.next());
        inventory.getItem(name).increaseQuantityInInventory(amount);
    }

    // REQUIRES: given grocery item must be in inventory
    // MODIFIES: this, groceryItem
    // EFFECTS: allows user to increase quantity of items already inside inventory
    public void decreaseItemInInventory() {
        displayInventory();
        System.out.println("Which of these items would you like to decrease? Enter its name:");
        String name = input.next();
        System.out.println("How many of this item would you like to decrease from your inventory?");
        int amount = Integer.parseInt(input.next());
        GroceryItem groceryItem = inventory.getItem(name);
        groceryItem.decreaseQuantityInInventory(amount);
        if (!groceryItem.isContainedInInventoryList()) {
            inventory.removeItem(groceryItem);
        }
    }

    // EFFECTS: display user's shopping list
    public void displayShoppingList() {
        printDivider();
        HashSet<GroceryItem> shoppingListList = shoppingList.getGroceryList();
        if (shoppingListList.size() == 0) {
            System.out.println("You do not have any items in your shopping list.");
        } else {
            System.out.println("You have the following in your shopping list:");
            for (GroceryItem i : shoppingListList) {
                System.out.println(
                        "\t" + i.getQuantityInShoppingList() + " " + i.getName() + " (" + i.getCategory() + ")");
            }
        }
    }

    // MODIFIES: this, shopping
    // EFFECTS: allows user to add items to shopping list
    public void addToShoppingList() {
        System.out.println("Is this a new item? (y/n)");
        String userInput = input.next();
        if (userInput.equals("y")) {
            System.out.println("Enter the name of the item you want to add to your shopping list:");
            String name = input.next();
            System.out.println("Enter its category:");
            String category = input.next();
            System.out.println("Enter quantity:");
            int quantity = input.nextInt();
            GroceryItem groceryItem = new GroceryItem(name, category);
            groceryItem.increaseQuantityInShoppingList(quantity);
            shoppingList.addItem(groceryItem);
        } else {
            System.out.println("Please select \'Increase/Decrease specific item in shopping list\' instead.");
        }
    }

    // REQUIRES: given grocery item must be in shopping list
    // MODIFIES: this, groceryItem
    // EFFECTS: allows user to increase quantity of items already inside shopping
    // list
    public void increaseItemInShoppingList() {
        displayShoppingList();
        System.out.println("Which of these items would you like to increase? Enter its name:");
        String name = input.next();
        System.out.println("How many of this item would you like to increase to your shopping list?");
        int amount = Integer.parseInt(input.next());
        shoppingList.getItem(name).increaseQuantityInShoppingList(amount);
    }

    // REQUIRES: given grocery item must be in shopping list
    // MODIFIES: this, groceryItem
    // EFFECTS: allows user to decrease quantity of items already inside shopping
    // list
    public void decreaseItemInShoppingList() {
        displayShoppingList();
        System.out.println("Which of these items would you like to decrease? Enter its name:");
        String name = input.next();
        System.out.println("How many of this item would you like to decrease from your shopping list?");
        int amount = Integer.parseInt(input.next());
        GroceryItem groceryItem = shoppingList.getItem(name);
        groceryItem.decreaseQuantityInShoppingList(amount);
        if (!groceryItem.isContainedInShoppingList()) {
            shoppingList.removeItem(groceryItem);
        }
    }

    // Used JsonSerializationDemo as reference (see repository URL above)   
    // REQUIRES: listType is either "inventory" or "shopping" 
    // EFFECTS: saves the grocery list to file
    private void saveGroceryList(String listType) {
        // TODO
    }

    // Used JsonSerializationDemo as reference (see repository URL above)
    // REQUIRES: listType is either "inventory" or "shopping"
    // MODIFIES: this
    // EFFECTS: loads grocery list from file
    private void loadGroceryList(String listType) {
        // TODO
    }

    // Used TellerApp as reference (see repository URL above)
    // EFFECTS: prints divider
    public void printDivider() {
        System.out.println("-----------------------------------------");
    }
}
