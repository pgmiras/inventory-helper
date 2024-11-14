package ui.screens.tools;

import java.awt.Container;
import java.awt.event.ActionEvent;

import javax.swing.*;

import ui.screens.MenuUI;

// Used SimpleDrawingPlayer as reference
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Starter

// Menu item for saving inventory
public class SaveInventoryMenu extends Tool {

    public SaveInventoryMenu(Container mainContainer, JComponent parent) {
        super(mainContainer, parent);
    }

    // EFFECTS: constructs the save inventory menu which is then added to parent
    @Override
    protected void createButton(JComponent parent) {
        button = new JMenuItem("Save inventory");
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
        JFrame frame = new JFrame();
        frame.add(new JLabel("saving inventory"));
        frame.setVisible(true);
    }

}
