package ui.screens.tools;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;

import javax.swing.*;

import model.GroceryList;
import persistence.JsonWriter;
import ui.screens.InventoryAppUI;

// Used SimpleDrawingPlayer as reference
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Starter

// Menu item for loading shopping list
public class LoadShoppingListTool extends Tool {

    public LoadShoppingListTool(Container mainContainer, JComponent parent) {
        super(mainContainer, parent);
    }

    // EFFECTS: constructs the load shopping list menu which is then added to parent
    @Override
    protected void createButton(JComponent parent) {
        button = new JMenuItem("Load shopping list");
        button.setIcon(loadIcon);
        addToParent(parent);
    }

    // MODIFIES: this
    // EFFECTS: constructs a new listener object which is added to the JMenuItem
    @Override
    protected void addListener() {
        button.addActionListener(this);
    }

    // EFFECTS: loads shopping list
    @Override
    public void actionPerformed(ActionEvent e) {
        ((InventoryAppUI) mainContainer).loadGroceryList("shopping list");
        JOptionPane.showMessageDialog(null,
                "Your inventory has been loaded.",
                "Shopping List Loaded Successfully",
                JOptionPane.INFORMATION_MESSAGE);
    }

}
