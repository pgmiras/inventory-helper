package ui.screens.tools;

import javax.swing.*;

import model.GroceryItem;
import model.GroceryList;
import ui.screens.MenuUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Used SimpleDrawingPlayer as reference
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Starter

public class IncreaseTool extends Tool {

    public IncreaseTool(MenuUI menu, JComponent parent) {
        super(menu, parent);
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

        String itemName = JOptionPane.showInputDialog(null,
                "Which item do you want to increase? Enter its name:",
                "Increase item",
                JOptionPane.QUESTION_MESSAGE);
        if (itemName == null) {
            return;
        }

        String increaseQuantityStr = JOptionPane.showInputDialog(null,
                "By how many?",
                "Increase item",
                JOptionPane.QUESTION_MESSAGE);
        if (increaseQuantityStr == null) {
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

}
