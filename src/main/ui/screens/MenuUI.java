package ui.screens;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import ui.*;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;

// Represents main menu to visualize grocery list and actions for that list
public class MenuUI extends JPanel {
    private static int WIDTH;
    private static int HEIGHT;

    private String listType;

    // private JComponent tablePane;

    // EFFECTS: constructs user interface for menu for grocery list
    public MenuUI(String listType, Component parent) {
        this.listType = listType;

        WIDTH = ((StartScreen) parent).getUserInterfaceWidth() / 2;
        HEIGHT = ((StartScreen) parent).getUserInterfaceHeight();
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout());

        add(new JLabel("What's in your " + this.listType + "?"), BorderLayout.NORTH);

        displayTablePane();
        //displayButtons();

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayButtons'");
    }
}
