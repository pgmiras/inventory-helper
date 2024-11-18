package ui.screens.tools;

import javax.swing.*;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

// Used SimpleDrawingPlayer as reference
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Starter

// "save" icon from <a href="https://www.flaticon.com/free-icons/save" title="save icons">Save icons created by Freepik - Flaticon</a>
// "open-file" icon <a href="https://www.flaticon.com/free-icons/folder" title="folder icons">Folder icons created by stockes_02 - Flaticon</a>

public abstract class Tool implements ActionListener {
    protected AbstractButton button;
    protected Container mainContainer;
    protected ImageIcon saveIcon;
    protected ImageIcon loadIcon;

	public Tool(Container mainContainer, JComponent parent) {
        this.mainContainer = mainContainer;
		loadImages();
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

    // EFFECTS: helper method to load images used as icons
    private void loadImages() {
        saveIcon = new ImageIcon("./resource/save.png");
        loadIcon = new ImageIcon("./resource/open-file.png");
    }

    public Container getJComponent() {
        return mainContainer;
    }
}
