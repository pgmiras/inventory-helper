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

// Menu item for saving inventory
public class SaveInventoryTool extends Tool {

    public SaveInventoryTool(Container mainContainer, JComponent parent) {
        super(mainContainer, parent);
    }

    // EFFECTS: constructs the save inventory menu which is then added to parent
    @Override
    protected void createButton(JComponent parent) {
        button = new JMenuItem("Save inventory");
        button.setIcon(saveIcon);
        addToParent(parent);
    }

    // MODIFIES: this
    // EFFECTS: constructs a new listener object which is added to the JMenuItem
    @Override
    protected void addListener() {
        button.addActionListener(this);
    }

    // EFFECTS: saves inventory
    @Override
    public void actionPerformed(ActionEvent e) {
        ((InventoryAppUI) mainContainer).saveGroceryList("inventory");
        JOptionPane.showMessageDialog(null,
            "Your inventory has been saved.",
            "Inventory Saved Successfully",
            JOptionPane.INFORMATION_MESSAGE);
    }

}
