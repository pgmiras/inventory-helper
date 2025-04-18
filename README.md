# Inventory

## A helper for shoppers

This application records a user’s inventory (what they have in their, e.g., fridge, pantry, etc.) and allows the user to add or remove items from this inventory. This helps them take note of the items they have used up and might need to replace or replenish, and categorize these items, for the next time they will go to the store. Anyone who does groceries or goes shopping, such as college students and families, can use this application. As a grocery shopper myself (and a college student learning to be an independent adult), I thought it would be helpful to have an app to take inventory of what I have and what I used up, so I don’t forget what I need to buy when it’s time to do groceries.

Some example scenarios where this application would be useful:
- I have two cartons of milk in the fridge. I used one carton this week, so I need to buy a carton of milk, which is in the dairy section of the grocery store.
- I have three cans of tuna in the pantry. I used two cans this week, so I need to buy two cans of tuna, which is in the canned foods section of the grocery store.

## User Stories
- As a user, I want to be able to add a new grocery item to my inventory, and specify its name, quantity, and category.
- As a user, I want to be able to add an existing grocery item to my inventory, and specify the quantity I have.
- As a user, I want to be able to view the list of grocery items in my inventory.
- As a user, I want to be able to modify a grocery item’s quantity in my inventory.
- As a user, I want to be able to remove a grocery item from my inventory (to indicate that it has been used up).
- As a user, I want to be able to add a new grocery item to my shopping list, and specify its name, quantity, and category.
- As a user, I want to be able to add an existing grocery item to my shopping list, and specify the quantity I need.
- As a user, I want to be able to view the list of grocery items in my shopping list.
- As a user, I want to be able to modify a grocery item's quantity in my shopping list.
- As a user, I want to be able to remove a grocery item from my shopping list.
- As a user, I want to be able to save my grocery lists (inventory and shopping list) to file whenever I want.
- As a user, I want to be able to load my grocery lists (inventory and shopping list) from file whenever I want.

## Instructions for End User

- You can generate the first required action related to the user story "adding multiple Xs to a Y" by clicking on the button “Add new item” under either the inventory panel or the shopping list panel to add new items into that particular list. An option pane will pop up.
    - Enter the item’s name.
    - Enter the item’s category.
    - Enter the item’s quantity.
- You can generate the second required action related to the user story "adding multiple Xs to a Y" by clicking on the button “Increase item” either under the inventory panel or the shopping list panel to increase an item already in that list. An option pane will pop up.
    - Enter the name of the item you want to increase.
    - Enter the amount you want to increase to that item’s quantity.
- Another action related to the user story “adding multiple Xs to a Y” is by clicking on the button “Decrease item” either under the inventory panel or the shopping list panel to decrease an item already in that list. An option pane will pop up.
    - Enter the name of the item you want to decrease.
    - Enter the amount you want to decrease from that item’s quantity.
- You can locate my visual component by clicking either the “Save” or “Load” menu
- You can save the state of my application by first clicking on “Save” menu, then,
    - Click on the “Save inventory” menu item to save inventory only.
    - Click on the “Save shopping list” menu item to save shopping list only.
    - Click on the “Save both” menu item to save both inventory and shopping list.
- You can reload the state of my application by first clicking on the “Load” menu, then,
    - Click on the “Load inventory” menu item to load inventory only.
    - Click on the “Load shopping list” menu item to load shopping list only.
    - Click on the “Load both” menu item to load both inventory and shopping list.

## Phase 4: Task 2
- GroceryItem
    - Increased `item name` in inventory by `amount`.
    - Decreased `item name` in inventory by `amount`.
    - Increased `item name` in shopping list by `amount`.
    - Decreased `item name` in shopping list by `amount`.
- GroceryList
    - Added `item name` (`item category`) to `inventory/shopping list`.
    - Removed `item name` (`item category`) from `inventory/shopping list`.

## Phase 4: Task 3

One refactoring I might do is to implement the Observer Pattern design. The Observable/Subject will be `GroceryList`, and its Observer will be `MenuUI`. For every time a `GroceryItem` is added to or removed from the `GroceryList`, or its quantity in that `GroceryList` is modified (increased or decreased), `MenuUI` will be notified and updated accordingly. Specifically, `MenuUI` will update by displaying a table with the correct set of grocery items with the correct name, category, and quantity. There already is an `update` method implemented in my `MenuUI` class, so I just need to create an `Observer` interface specifying an `update` method and have `MenuUI` implement this interface. I will then create an `Observable` class which `GroceryList` would then have to extend. This `Observable` class will have the `addObserver`, `removeObserver`, and `notifyObserver` methods. After the two `GroceryList` classes and two `MenuUI` classes are instantiated in `InventoryAppUI`, these two `MenuUI` classes will be added as observers to the two `GroceryList` classes respectively.

Doing this could remove the direct association between `MenuUI` and `GroceryList`, and decrease the coupling between the model and user interface (UI). This is so that the point of access between the model and the UI is the association between `GroceryList` and `InventoryAppUI`, and so that `MenuUI` will have to depend on `InventoryAppUI` only rather than on both `InventoryAppUI` and `GroceryList`.

## Image Attributions
[Save icons created by Freepik](https://www.flaticon.com/free-icon/save_4743125?term=save&page=1&position=29&origin=tag&related_id=4743125) - [Flaticon](https://www.flaticon.com/free-icons/save)

[Folder icons created by stockes_02](https://www.flaticon.com/free-icon/open-file_4847443?related_id=4847443&origin=pack) - [Flaticon](https://www.flaticon.com/free-icons/folder)
