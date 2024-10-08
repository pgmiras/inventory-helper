package ui;

import java.util.Scanner;
import java.util.HashSet;

import model.GroceryItem;
import model.GroceryList;

// Inventory application
public class InventoryApp {
    private GroceryList inventory = new GroceryList();
    private GroceryList shoppingList = new GroceryList();
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
        System.out.println("\tc -> Increase specific item in inventory");
        System.out.println("\td -> Decrease specific item in inventory");
        System.out.println("\te -> View shopping list");
        System.out.println("\tf -> Add to shopping list");
        System.out.println("\tg -> Increase specific item in shopping list");
        System.out.println("\th -> Decrease specific item in shopping list");
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
        // else if (command.equals("c")) {
        //     increaseItemInInventory();
        // }
        
        // TODO add the other options
    }

    // EFFECTS: display user's inventory
    public void displayInventory() {
        HashSet<GroceryItem> inventoryList = inventory.getGroceryList();
        if (inventoryList.size() == 0) {
            System.out.println("You do not have any items in your inventory.");
        } else {
            System.out.println("You have the following in your inventory:");
            for (GroceryItem i : inventoryList) {
                System.out.println("\t" + i.getQuantityInInventory() + " " + i.getName());
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
            System.out.println("Enter quantity");
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
        // TODO: increase quantity
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

    // REQUIRES: given grocery item must be in shopping list
    // MODIFIES: this, groceryItem
    // EFFECTS: allows user to increase quantity of items already inside shopping list
    public void increaseItemInShoppingList() {
        // TODO
    }

    // REQUIRES: given grocery item must be in shopping list
    // MODIFIES: this, groceryItem
    // EFFECTS: allows user to decrease quantity of items already inside shopping list
    public void decreaseItemInShoppingList() {
        // TODO
    }
}
