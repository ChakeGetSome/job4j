package ru.job4j.tracker;

public class FindItemByName implements UserAction{
    private final int findByName;
    private String message;

    public FindItemByName(int findByName, String message) {
        this.findByName = findByName;
        this.message = message;
    }
    @Override
    public int key() {
        return findByName;
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

    @Override
    public String info() {
        return message;
    }
}