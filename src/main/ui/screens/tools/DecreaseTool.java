package ui.screens.tools;

import javax.swing.*;

import model.GroceryItem;
import model.GroceryList;
import ui.screens.MenuUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Used SimpleDrawingPlayer as reference
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Starter

public class DecreaseTool extends Tool {

    public DecreaseTool(MenuUI menu, JComponent parent) {
        super(menu, parent);
    }

    // MODIFIES: this
    // EFFECTS: constructs an add button which is then added to the JComponent
    // (parent)
    // which is passed in as a parameter
    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Decrease item");
        addToParent(parent);
    }

    // MODIFIES: this
    // EFFECTS: constructs a new listener object which is added to the JButton
    @Override
    protected void addListener() {
        button.addActionListener(this);
    }

    // REQUIRES: item is in grocery list
    // EFFECTS: asks user the name and amount of the item they'd like to decrease
    // then decreases quantity of that item in the grocery list by that amount
    @Override
    public void actionPerformed(ActionEvent e) {
        // JFrame frame = new JFrame("decrease tool" +
        // getMenuUI().getGroceryList().getListType()); // TODO to delete
        // frame.setVisible(true); // TODO to delete

        String itemName = JOptionPane.showInputDialog(null,
                "Which item do you want to decrease? Enter its name:",
                "Decrease item",
                JOptionPane.QUESTION_MESSAGE);
        if (itemName == null) {
            return;
        }

        String decreaseQuantityStr = JOptionPane.showInputDialog(null,
                "By how many?",
                "Decrease item",
                JOptionPane.QUESTION_MESSAGE);
        if (decreaseQuantityStr == null) {
            return;
        }
        int decreaseQuantity = Integer.parseInt(decreaseQuantityStr);

        GroceryList groceryList = ((MenuUI) mainContainer).getGroceryList();
        GroceryItem groceryItem = groceryList.getItem(itemName);
        if (groceryList.getListType() == "inventory") {
            groceryItem.decreaseQuantityInInventory(decreaseQuantity);
            if (groceryItem.getQuantityInInventory() <= 0) {
                groceryList.removeItem(groceryItem);
            }
        } else if (groceryList.getListType() == "shopping list") {
            groceryItem.decreaseQuantityInShoppingList(decreaseQuantity);
            if (groceryItem.getQuantityInShoppingList() <= 0) {
                groceryList.removeItem(groceryItem);
            }
        }
        ((MenuUI) mainContainer).update();
    }

}
