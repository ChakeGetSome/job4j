package ru.job4j.tracker;

public class FindItemByName extends BaseAction {

    public FindItemByName(int findByName, String message) {
        super(findByName, message);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("------------ Finding items by name--------------");
        String name = input.ask("Please, provide item name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            System.out.println("------------ All items with name " + name + "--------------");
            for (Item item : items) {
                System.out.println(String.format("------------ Item with Id : %s, Name : %s, Description : %s", item.getId(), item.getName(), item.getDesc()));
            }
        } else {
            System.out.println("------------ There are no items with such name --------------");
        }
    }
}