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

public class IncreaseTool extends Tool {
    GroceryList groceryList;

    public IncreaseTool(MenuUI menu, JComponent parent) {
        super(menu, parent);
        groceryList = ((MenuUI) mainContainer).getGroceryList();
    }

    // MODIFIES: this
    // EFFECTS: constructs an add button which is then added to the JComponent
    // (parent)
    // which is passed in as a parameter
    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Increase item");
        addToParent(parent);
    }

    // MODIFIES: this
    // EFFECTS: constructs a new listener object which is added to the JButton
    @Override
    protected void addListener() {
        button.addActionListener(this);
    }

    // REQUIRES: item is in grocery list
    // EFFECTS: asks user the name and amount of the item they'd like to increase
    // then increases quantity of that item in the grocery list by that amount
    @Override
    public void actionPerformed(ActionEvent e) {
        if (doNotContinue("start", "")) {
            return;
        }

        String itemName = showOptionPane("Which item do you want to increase? Enter its name:");
        if (doNotContinue("itemName", itemName)) {
            return;
        }

        String increaseQuantityStr = showOptionPane("By how many?");
        if (doNotContinue("itemQuantity", increaseQuantityStr)) {
            return;
        }
        int increaseQuantity = Integer.parseInt(increaseQuantityStr);

        GroceryList groceryList = ((MenuUI) mainContainer).getGroceryList();
        GroceryItem groceryItem = groceryList.getItem(itemName);
        if (groceryList.getListType() == "inventory") {
            groceryItem.increaseQuantityInInventory(increaseQuantity);
        } else if (groceryList.getListType() == "shopping list") {
            groceryItem.increaseQuantityInShoppingList(increaseQuantity);
        }
        ((MenuUI) mainContainer).update();
    }

    // EFFECTS: checks if method should not continue at the given point, with given
    // input
    private boolean doNotContinue(String point, String input) {
        boolean doNotContinue = false;
        switch (point) {
            case "start":
                doNotContinue = emptyGroceryList();
                break;
            case "itemName":
                doNotContinue = invalidItemName(input);
                break;
            case "itemQuantity":
                doNotContinue = invalidItemQuantity(input);
                break;
        }
        return doNotContinue;
    }

    // EFFECTS: checks if the grocery list is empty
    private boolean emptyGroceryList() {
        boolean emptyGroceryList = false;
        if (groceryList.getGroceryList().isEmpty()) {
            emptyGroceryList = true;
            JOptionPane.showMessageDialog(null,
                    "Your " + groceryList.getListType() + " is empty.",
                    "Could Not Perform Action",
                    JOptionPane.ERROR_MESSAGE);
        }
        return emptyGroceryList;
    }

    // EFFECTS: checks if given item name is valid
    private boolean invalidItemName(String itemName) {
        Set<GroceryItem> groceryListList = groceryList.getGroceryList();
        GroceryItem groceryItem = groceryList.getItem(itemName);
        boolean doNotContinue = false;
        if (!groceryListList.contains(groceryItem)) {
            doNotContinue = true;
            JOptionPane.showMessageDialog(null,
                    "You do not have " + itemName + " in your " + groceryList.getListType(),
                    "Could Not Perform Action",
                    JOptionPane.ERROR_MESSAGE);
        }
        if (itemName == null) {
            doNotContinue = true;
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
    
    // EFFECTS: creates JOptionPane with given message
    private String showOptionPane(String message) {
        return JOptionPane.showInputDialog(null,
                message,
                "Increase item",
                JOptionPane.QUESTION_MESSAGE);
    }

}
