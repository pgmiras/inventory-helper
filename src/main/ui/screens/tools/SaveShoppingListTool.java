package ui.screens.tools;

import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import ui.screens.InventoryAppUI;

public class SaveShoppingListTool extends Tool {

    public SaveShoppingListTool(Container mainContainer, JComponent parent) {
        super(mainContainer, parent);
    }

    // EFFECTS: constructs the save shopping list menu which is then added to parent
    @Override
    protected void createButton(JComponent parent) {
        button = new JMenuItem("Save shopping list");
        addToParent(parent);
    }

    // MODIFIES: this
    // EFFECTS: constructs a new listener object which is added to the JMenuItem
    @Override
    protected void addListener() {
        button.addActionListener(this);
    }

    // EFFECTS: saves shopping list
    @Override
    public void actionPerformed(ActionEvent e) {
        ((InventoryAppUI) mainContainer).saveGroceryList("shopping list");
        JOptionPane.showMessageDialog(null,
            "Your shopping list has been saved.",
            "Shopping List Saved Successfully",
            JOptionPane.INFORMATION_MESSAGE);
    }
}
