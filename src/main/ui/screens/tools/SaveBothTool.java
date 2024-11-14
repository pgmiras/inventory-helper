package ui.screens.tools;

import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import ui.screens.InventoryAppUI;

public class SaveBothTool extends Tool {

    public SaveBothTool(Container mainContainer, JComponent parent) {
        super(mainContainer, parent);
    }

    // EFFECTS: constructs menu to save both grocery lists which is then added to parent
    @Override
    protected void createButton(JComponent parent) {
        button = new JMenuItem("Save both");
        addToParent(parent);
    }

    // MODIFIES: this
    // EFFECTS: constructs a new listener object which is added to the JMenuItem
    @Override
    protected void addListener() {
        button.addActionListener(this);
    }

    // EFFECTS: saves both inventory and shopping list
    @Override
    public void actionPerformed(ActionEvent e) {
        ((InventoryAppUI) mainContainer).saveGroceryList("inventory");
        ((InventoryAppUI) mainContainer).saveGroceryList("shopping list");
        JOptionPane.showMessageDialog(null,
            "Your inventory and your shopping list have been saved.",
            "Grocery Lists Saved Successfully",
            JOptionPane.INFORMATION_MESSAGE);
    }
}
