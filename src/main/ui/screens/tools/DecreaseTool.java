package ui.screens.tools;

import javax.swing.*;

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
    // EFFECTS:  constructs an add button which is then added to the JComponent (parent)
    //           which is passed in as a parameter
	@Override
	protected void createButton(JComponent parent) {
		button = new JButton("Decrease item");
		addToParent(parent);
	}

    // MODIFIES: this
    // EFFECTS:  constructs a new listener object which is added to the JButton
	@Override
	protected void addListener() {
		button.addActionListener(this);
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame("decrease tool" + getMenuUI().getGroceryList().getListType());
        frame.setVisible(true);
    }

}
