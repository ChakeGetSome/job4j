package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public int getActionsLentgh() {
        return this.actions.size();
    }

    public void fillActions() {
        this.actions.add(new AddItem(0, "0. Add item"));
        this.actions.add(new ShowItems(1, "1. Show all items"));
        this.actions.add(new UpdateItem(2, "2. Update item"));
        this.actions.add(new DeleteItem(3, "3. Delete item"));
        this.actions.add(new FindItemById(4, "4. Find item by id"));
        this.actions.add(new FindItemByName(5, "5. Find items by name"));
        this.actions.add(new ExitProgram(6, "6. Exit Program"));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if(action != null) {
                System.out.println(action.info());
            }
        }
    }
}