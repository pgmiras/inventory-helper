package ui.screens;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import model.GroceryItem;
import model.GroceryList;
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

    private JScrollPane tablePane;
    private JTable table;

    private List<Tool> tools;
    private GroceryList groceryList;

    // private JComponent tablePane;

    // EFFECTS: constructs user interface for menu for grocery list
    public MenuUI(GroceryList groceryList, Component parent) {
        this.groceryList = groceryList;
        table = makeTable();

        WIDTH = ((StartScreen) parent).getUserInterfaceWidth() / 2;
        HEIGHT = ((StartScreen) parent).getUserInterfaceHeight();
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        Border border = BorderFactory.createLineBorder(Color.black);
        setLayout(new BorderLayout());
        setBorder(border);

        add(new JLabel("What's in your " + groceryList.getListType() + "?"), BorderLayout.NORTH);

        displayTablePane();
        displayButtons();

        setVisible(true);

        // TODO
    }

    // EFFECTS: constructs pane containing table
    private void displayTablePane() {
        JComponent panel = new JPanel();

        JLabel text = new JLabel();
            text.setText("<HTML>You don't have any items in your " + groceryList.getListType()
                    + ". <br> Start adding items or load a saved list.<HTML>");
        panel.add(text);

        tablePane = new JScrollPane(panel);
        add(tablePane, BorderLayout.CENTER);
    }

    // EFFECTS: constructs table to view items
    private JTable makeTable() {
        String[] header = { "Name", "Category", "Quantity" };
        // String[][] data = { // TODO to delete
        //     {"test name", "test category", "test quantity"},
        //     {"test name 2", "test category 2", "test quantity 2"}};
        //DefaultTableModel model = new DefaultTableModel(data, header); // TODO to delete
        DefaultTableModel model = new DefaultTableModel(header, 0);
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(WIDTH, HEIGHT));
        return table;
        // TODO
    }

    // EFFECTS: updates table with updated data
    private void updateTable() {
        TableModel model = table.getModel();
        for (GroceryItem item : groceryList.getGroceryList()) {
            String itemName = item.getName();
            String itemCategory = item.getCategory();
            String itemQuantity = "";
            if (groceryList.getListType() == "inventory") {
                itemQuantity = String.valueOf(item.getQuantityInInventory());
            } else {
                itemQuantity = String.valueOf(item.getQuantityInShoppingList());
            }
            String[] row = {itemName, itemCategory, itemQuantity};
            ((DefaultTableModel) model).addRow(row);
        }
    }

    // EFFECTS: constructs panel containing buttons
    private void displayButtons() {
        JPanel toolArea = new JPanel();
		toolArea.setLayout(new GridLayout(0,1));

        AddTool addTool = new AddTool(this, toolArea);
        IncreaseTool increaseTool = new IncreaseTool(this, toolArea);
        DecreaseTool decreaseTool = new DecreaseTool(this, toolArea);

        add(toolArea, BorderLayout.SOUTH);
        // TODO
    }

    // MODIFIES: this
    // EFFECTS: updates this when there are changes to grocery list data
    public void update() {
        table = makeTable();
        updateTable();
        tablePane.setViewportView(table);
    }

    public GroceryList getGroceryList() {
        return groceryList;
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }
}
