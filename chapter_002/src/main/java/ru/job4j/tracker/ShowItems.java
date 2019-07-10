package ru.job4j.tracker;

public class ShowItems extends BaseAction {

    public ShowItems(int show, String message) {
        super(show, message);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        if(items.length > 0) {
            System.out.println("------------ All items --------------");
            for (Item item : items) {
                System.out.println(String.format("------------ Item with Id : %s, Name : %s, Description : %s", item.getId(), item.getName(), item.getDesc()));
            }
        } else {
            System.out.println("------------ There are no items --------------");
        }
    }
}