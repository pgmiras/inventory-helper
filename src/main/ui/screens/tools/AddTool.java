package ui.screens.tools;

import javax.swing.*;

import model.GroceryItem;
import model.GroceryList;
import ui.screens.MenuUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

// Used SimpleDrawingPlayer as reference
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Starter

public class AddTool extends Tool {
    GroceryList groceryList;

    public AddTool(MenuUI menu, JComponent parent) {
        super(menu, parent);
        groceryList = ((MenuUI) mainContainer).getGroceryList();
    }

    // MODIFIES: this
    // EFFECTS: constructs an add button which is then added to the JComponent
    // (parent)
    // which is passed in as a parameter
    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Add new item");
        addToParent(parent);
    }

    // MODIFIES: this
    // EFFECTS: constructs a new listener object which is added to the JButton
    @Override
    protected void addListener() {
        button.addActionListener(this);
    }

    // EFFECTS: asks user the name, category, and quantity of the new item
    // then adds new item to grocery list
    @Override
    public void actionPerformed(ActionEvent e) {
        String itemName = showOptionPane("Item name?");
        if (doNotContinue("itemName", itemName)) {
            return;
        }

        String itemCategory = showOptionPane("Item category?");
        if (itemCategory == null) {
            return;
        }

        String itemQuantityStr = showOptionPane("Item quantity?");
        if (doNotContinue("itemQuantity", itemQuantityStr)) {
            return;
        }
        
        int itemQuantity = Integer.parseInt(itemQuantityStr);
        updateGroceryList(itemName, itemCategory, itemQuantity);
    }

    // // EFFECTS: checks if method should not continue at the given point
    // private boolean doNotContinue(String point, String input "") {
    // boolean doNotContinue = false;
    // switch (point) {
    // case "start":
    // doNotContinue = emptyGroceryList();
    // break;

    // }
    // return doNotContinue;
    // }

    // EFFECTS: creates JOptionPane with given message
    private String showOptionPane(String message) {
        return JOptionPane.showInputDialog(null,
                message,
                "Enter new item information",
                JOptionPane.QUESTION_MESSAGE);
    }

    // EFFECTS: checks if method should not continue at the given point, with given
    // input
    private boolean doNotContinue(String point, String input) {
        boolean doNotContinue = false;
        switch (point) {
            case "itemName":
                doNotContinue = invalidItemName(input);
                break;
            case "itemQuantity":
                doNotContinue = invalidItemQuantity(input);
                break;
        }
        return doNotContinue;
    }

    // EFFECTS: checks if given item quantity is valid
    private boolean invalidItemQuantity(String input) {
        boolean doNotContinue = false;
        if (input == null) {
            doNotContinue = true;
        }
        if (Integer.parseInt(input) < 0) {
            doNotContinue = true;
            JOptionPane.showMessageDialog(null,
                    "You entered a negative value",
                    "Could Not Perform Action",
                    JOptionPane.ERROR_MESSAGE);
        }
        return doNotContinue;
    }

    // EFFECTS: checks if given item name is valid
    private boolean invalidItemName(String itemName) {
        Set<GroceryItem> groceryListList = groceryList.getGroceryList();
        GroceryItem groceryItem = groceryList.getItem(itemName);
        boolean doNotContinue = false;
        if (groceryListList.contains(groceryItem)) {
            doNotContinue = true;
            JOptionPane.showMessageDialog(null,
                    "You already have " + itemName + " in your " + groceryList.getListType(),
                    "Could Not Perform Action",
                    JOptionPane.ERROR_MESSAGE);
        }
        if (itemName == null) {
            doNotContinue = true;
        }
        return doNotContinue;
    }

    // EFFECTS: checks user's inputs and indicates whether caller method should not
    // continue
    // private boolean checkInput(String itemName, int itemQuantity) {
    // boolean doNotContinue = false;
    // Set<GroceryItem> groceryListList = groceryList.getGroceryList();
    // String message = "";
    // GroceryItem groceryItem = groceryList.getItem(itemName);
    // if () {

    // }
    // JOptionPane.showMessageDialog(null, message, "Dialog",
    // JOptionPane.ERROR_MESSAGE);
    // return doNotContinue;
    // }

    // MODIFIES: grocery list
    // EFFECTS: adds new item to grocery list with given name, category, and
    // quantity
    private void updateGroceryList(String itemName, String itemCategory, int itemQuantity) {
        GroceryItem groceryItem = new GroceryItem(itemName, itemCategory);
        if (groceryList.getListType() == "inventory") {
            groceryItem.increaseQuantityInInventory(itemQuantity);
        } else if (groceryList.getListType() == "shopping list") {
            groceryItem.increaseQuantityInShoppingList(itemQuantity);
        }
        groceryList.addItem(groceryItem);
        ((MenuUI) mainContainer).update();
    }

}
