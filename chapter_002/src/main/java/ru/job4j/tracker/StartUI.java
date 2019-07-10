package ru.job4j.tracker;
import java.util.*;

public class StartUI {
    private final Input input;
    private final Tracker tracker;
    private boolean working;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
        this.working = working;
    }

    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions(this);
        int[] range = new int[menu.getActionsLentgh()];
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range[i] = i;
            do {
                menu.show();
                menu.select(input.ask("select: ", range));
            } while (this.working);
        }
    }

        public void stop(){
            this.working = false;
        }
    }


