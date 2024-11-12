package ui.screens.tools;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Used SimpleDrawingPlayer as reference
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Starter

public class AddTool extends Tool {

    public AddTool(JComponent parent) {
        super(parent);
    }

    // MODIFIES: this
    // EFFECTS:  constructs an add button which is then added to the JComponent (parent)
    //           which is passed in as a parameter
	@Override
	protected void createButton(JComponent parent) {
		button = new JButton("Add item");
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
        JFrame frame = new JFrame("add tool");
        frame.setVisible(true);
    }

}
