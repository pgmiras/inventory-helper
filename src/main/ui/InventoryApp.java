package ui;

import java.util.Scanner;
import java.util.HashSet;

import model.GroceryItem;
import model.InventoryList;

// Inventory application
public class InventoryApp {
    private InventoryList inventory = new InventoryList();
    private Scanner input = new Scanner(System.in);

    // EFFECTS: runs the inventory application
    public InventoryApp() {
        runInventoryApp();
    }

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
        // TODO
    }

    // EFFECTS: display menu of options to user
    public void displayMenu() {
        System.out.println("Select from:");
        System.out.println("\ta -> View inventory");
        System.out.println("\tb -> Add to inventory");
        System.out.println("\tc -> Modify items in inventory");
        System.out.println("\td -> View shopping list");
        System.out.println("\te -> Add to shopping list");
        System.out.println("\tf -> Modify items in shopping list");
        System.out.println("\tz -> Quit");
    }

    // REQUIRES: command has non-zero length
    // MODIFIES: this
    // EFFECTS: processes user command
    public void processCommand(String command) {
        if (command.equals("a")) {
            displayInventory();
        } else if (command.equals("b")) {
            addToInventory();
        }
        // TODO add the other options
    }

    // EFFECTS: display user's inventory
    public void displayInventory() {
        HashSet<GroceryItem> inventoryList = inventory.getInventoryList();
        if (inventoryList.size() == 0) {
            System.out.println("You do not have any items in your inventory.");
        } else {
            System.out.println("You have the following in your inventory:");
            for (GroceryItem i : inventoryList) {
                System.out.println("\t" + i.getQuantityInInventory() + " " + i.getName());
            }
        }
    }

    // MODIFIES: this, inventory
    // EFFECTS: allows user to add items to inventory
    public void addToInventory() {
        System.out.println("Is this a new item? (y/n)");
        String userInput = input.next();
        if (userInput.equals("y")) {
            System.out.println("Enter the name of the item you want to add to your inventory:");
            String name = input.next();
            System.out.println("Enter its category:");
            String category = input.next();
            System.out.println("Enter quantity");
            int quantity = input.nextInt();
            GroceryItem groceryItem = new GroceryItem(name, category);
            groceryItem.setQuantityInInventory(quantity);
            inventory.addItem(groceryItem);
        } else {
            System.out.println("Please select \'Modify items in inventory\' instead.");
        }
    }

    // MODIFIES: this, inventory
    // EFFECTS: allows user to modify items already inside inventory
    public void modifyInventory() {
        // TODO
    }

    // EFFECTS: display user's shopping list
    public void displayShoppingList() {
        // TODO
    }

    // MODIFIES: this, shopping
    // EFFECTS: allows user to add items to inventory
    public void addToShoppingList() {
        // TODO
    }

    // MODIFIES: this, shopping
    // EFFECTS: allows user to modify items already inside shopping list
    public void modifyShoppingList() {
        // TODO
    }
}
