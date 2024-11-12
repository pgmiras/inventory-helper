package ui.screens.tools;

import javax.swing.*;

import model.GroceryItem;
import ui.screens.MenuUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Used SimpleDrawingPlayer as reference
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Starter

public class AddTool extends Tool {

    public AddTool(MenuUI menu, JComponent parent) {
        super(menu, parent);
    }

    // MODIFIES: this
    // EFFECTS: constructs an add button which is then added to the JComponent
    // (parent)
    // which is passed in as a parameter
    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Add item");
        addToParent(parent);
    }

    // MODIFIES: this
    // EFFECTS: constructs a new listener object which is added to the JButton
    @Override
    protected void addListener() {
        button.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String itemName = JOptionPane.showInputDialog(null,
            "Item name?",
            "Enter new item information",
            JOptionPane.QUESTION_MESSAGE);
        
        String itemCategory = JOptionPane.showInputDialog(null,
            "Item category?",
            "Enter new item information",
            JOptionPane.QUESTION_MESSAGE);

        String itemQuantityStr = JOptionPane.showInputDialog(null,
            "Item quantity?",
            "Enter new item information",
            JOptionPane.QUESTION_MESSAGE);
        int itemQuantity = Integer.parseInt(itemQuantityStr);

        GroceryItem groceryItem = new GroceryItem(itemName, itemCategory);
        groceryItem.increaseQuantityInInventory(itemQuantity);
        menu.getGroceryList().addItem(groceryItem);
    }

}
