package ui.screens.tools;

import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.JComponent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import ui.screens.InventoryAppUI;

public class LoadBothTool extends Tool {

    public LoadBothTool(Container mainContainer, JComponent parent) {
        super(mainContainer, parent);
    }

    // EFFECTS: constructs menu to load both grocery lists which is then added to parent
    @Override
    protected void createButton(JComponent parent) {
        button = new JMenuItem("Load both");
        addToParent(parent);
    }

    // MODIFIES: this
    // EFFECTS: constructs a new listener object which is added to the JMenuItem
    @Override
    protected void addListener() {
        button.addActionListener(this);
    }

    // EFFECTS: loads both inventory and shopping list
    @Override
    public void actionPerformed(ActionEvent e) {
        ((InventoryAppUI) mainContainer).loadGroceryList("inventory");
        ((InventoryAppUI) mainContainer).loadGroceryList("shopping list");
        JOptionPane.showMessageDialog(null,
            "Your inventory and your shopping list have been loaded.",
            "Grocery Lists Loaded Successfully",
            JOptionPane.INFORMATION_MESSAGE);
    }
}
