package ui.screens.tools;

import javax.swing.*;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Used SimpleDrawingPlayer as reference
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Starter

public abstract class Tool implements ActionListener {
    protected AbstractButton button;
    protected Container mainContainer;

	public Tool(Container mainContainer, JComponent parent) {
        this.mainContainer = mainContainer;
		createButton(parent);
		addToParent(parent);
		addListener();
	}

    // EFFECTS: creates button to activate tool
	protected abstract void createButton(JComponent parent);

	// EFFECTS: adds a listener for this tool
	protected abstract void addListener();

	// MODIFIES: parent
	// EFFECTS:  adds the given button to the parent component
	public void addToParent(JComponent parent) {
		parent.add(button);
	}

    public Container getJComponent() {
        return mainContainer;
    }
}
