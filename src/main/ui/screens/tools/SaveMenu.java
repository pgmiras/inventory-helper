package ui.screens.tools;

import java.awt.event.ActionEvent;

import javax.swing.JComponent;

import ui.screens.MenuUI;

// Used SimpleDrawingPlayer as reference
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Starter

// Menu button for saving at the top of the screen
public class SaveMenu extends Tool {

    public SaveMenu(JComponent mainContainer, JComponent parent) {
        super(mainContainer, parent);
        //TODO Auto-generated constructor stub
    }

    // EFFECTS: constructs the save menu which is then added to parent
    @Override
    protected void createButton(JComponent parent) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createButton'");
    }

    // MODIFIES: this
    // EFFECTS: constructs a new listener object which is added to the JMenu
    @Override
    protected void addListener() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addListener'");
    }

    // EFFECTS: opens JMenuItems related to saving
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
