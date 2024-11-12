package ui.screens;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

import ui.*;
import ui.screens.tools.*;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

// Used SimpleDrawingPlayer as reference
// Repository URL: https://github.students.cs.ubc.ca/CPSC210/SimpleDrawingPlayer-Starter

// Represents main menu to visualize grocery list and actions for that list
public class MenuUI extends JPanel {
    private static int WIDTH;
    private static int HEIGHT;

    private String listType;
    private List<Tool> tools;

    // private JComponent tablePane;

    // EFFECTS: constructs user interface for menu for grocery list
    public MenuUI(String listType, Component parent) {
        this.listType = listType;

        WIDTH = ((StartScreen) parent).getUserInterfaceWidth() / 2;
        HEIGHT = ((StartScreen) parent).getUserInterfaceHeight();
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        Border border = BorderFactory.createLineBorder(Color.black);
        setLayout(new BorderLayout());
        setBorder(border);

        add(new JLabel("What's in your " + this.listType + "?"), BorderLayout.NORTH);

        displayTablePane();
        displayButtons();

        setVisible(true);

        // TODO
    }

    // EFFECTS: constructs pane containing table
    private void displayTablePane() {
        JPanel panel = new JPanel();
        JLabel text = new JLabel();
        text.setText("<HTML>You don't have any items in your " + listType
                + ". <br> Start adding items or load a saved list.<HTML>");
        panel.add(text);
        // panel.add(makeTable());
        JScrollPane tablePane = new JScrollPane(panel);
        // displayTable();
        add(tablePane, BorderLayout.CENTER);
    }

    // EFFECTS: constructs table to view items
    private JTable makeTable() {
        String[] header = { "Name", "Category", "Quantity" };
        DefaultTableModel model = new DefaultTableModel(header, 0);
        JTable table = new JTable(model);
        return table;
        // TODO
    }

    private void displayButtons() {
        JPanel toolArea = new JPanel();
		toolArea.setLayout(new GridLayout(0,1));

        AddTool addTool = new AddTool(toolArea);
        IncreaseTool increaseTool = new IncreaseTool(toolArea);
        DecreaseTool decreaseTool = new DecreaseTool(toolArea);

        add(toolArea, BorderLayout.SOUTH);
        // TODO
    }
}
